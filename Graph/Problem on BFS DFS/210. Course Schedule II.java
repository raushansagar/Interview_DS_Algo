/*
    210. Course Schedule II
    Leetcode Link :- https://leetcode.com/problems/course-schedule-ii/description/
*/



// DFS
class Solution {
    public boolean DFS(int u, Map<Integer, List<Integer>> adj, boolean[] vis, boolean[] inRecursion, List<Integer> list){

        vis[u] = true;
        inRecursion[u] = true;

        for(int v : adj.getOrDefault(u, new ArrayList<>())){
            if(inRecursion[v]) return true;

            if(!vis[v] && DFS(v, adj, vis, inRecursion, list)){
                return true;
            }
        }

        list.add(u);
        inRecursion[u] = false;
        
        return false;
    }
    public int[] findOrder(int V, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] d : prerequisites){
            int u = d[0];
            int v = d[1];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[V];
        List<Integer> list = new ArrayList<>();

        for(int u = 0; u < V; u++){
            boolean[] inRecursion = new boolean[V];

            if(!vis[u] && DFS(u, adj, vis, inRecursion, list)){
                return new int[]{};
            }
        }

        int[] ans = new int[V];
        for(int i = 0; i < V; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}