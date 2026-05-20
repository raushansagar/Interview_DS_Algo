/*
    207. Course Schedule
    Leetcode Link :- https://leetcode.com/problems/course-schedule/description/
*/



class Solution {
    public boolean DFS(int u, Map<Integer, List<Integer>> adj, boolean[] vis, boolean[] inRecursion){
        vis[u] = true;
        inRecursion[u] = true;

        for(int v : adj.getOrDefault(u, new ArrayList<>())){
            if(inRecursion[v]) return true;

            if(!vis[v] && DFS(v, adj, vis, inRecursion)){
                return true;
            }
        }

        inRecursion[u] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] d : prerequisites){
            int u = d[0];
            int v = d[1];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[numCourses];
        for(int u = 0; u < numCourses; u++){
            boolean[] inRecursion = new boolean[numCourses];

            if(!vis[u] && DFS(u, adj, vis, inRecursion)){
                return false;
            }
        }

        return true;
    }
}

