/*
    802. Find Eventual Safe States
    Leetcode Link :-  https://leetcode.com/problems/find-eventual-safe-states/description/
*/



class Solution {
    public boolean DFS(int u, int[][] edges, boolean[] vis, boolean[] inRecursion){
        
        vis[u] = true;
        inRecursion[u] = true;

        for(int v : edges[u]){
            if(inRecursion[v]) return true;

            if(!vis[v] && DFS(v, edges, vis, inRecursion)){
                return true;
            }
        }

        inRecursion[u] = false;

        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        List<Integer> result = new ArrayList<>();

        for(int u = 0; u < V; u++){
            if(!vis[u]){
                DFS(u, graph, vis, inRecursion);
            }
        }

        for(int i = 0; i < inRecursion.length; i++){
            if(!inRecursion[i]) result.add(i);
        }

        return result;
    }
}