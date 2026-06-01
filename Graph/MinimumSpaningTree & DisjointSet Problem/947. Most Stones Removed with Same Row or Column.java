

/*
    947. Most Stones Removed with Same Row or Column
*/


 // DFS
class Solution {
    public void DFS(int u, int[][] stones, boolean[] vis, int n){

        vis[u] = true;

        for(int v = 0; v < n; v++){
            int r = stones[u][0];
            int c = stones[u][1];

            if(!vis[v] && (stones[v][0] == r || stones[v][1] == c)){
                DFS(v, stones, vis, n);
            }
        }

    }
    public int removeStones(int[][] stones) {
        
        int n = stones.length;

        boolean[] vis = new boolean[n];
        int group = 0;

        for(int u = 0; u < n; u++){
            if(!vis[u]){
                DFS(u, stones, vis, n);
                group++;
            }
        }

        return n-group;
    }
}





// DSU 

class Solution {

    // find and union by path compression
    public int find(int x, int[] parent){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x], parent);
    }

    public void union(int x, int y, int[] rank, int[] parent){

        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if(x_parent == y_parent) return;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[y_parent] > rank[x_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int V = accounts.size();

        int[] rank = new int[V];
        int[] parent = new int[V];

        for(int i = 0; i < V; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        Map<String, Integer> map = new HashMap<>();

        for(int x = 0; x < V; x++){
            for(int j = 1; j < accounts.get(x).size(); j++){
                String s = accounts.get(x).get(j);

                if(map.containsKey(s)){
                    int y = map.get(s);

                    int y_parent = find(y, parent);
                    int x_parent = find(x, parent);
                    
                    if(x_parent == y_parent) continue;

                    union(y, x, rank, parent);
                }
                else{
                    map.put(s, x);
                }
            }
        }

        Map<Integer, LinkedList<String>> list = new HashMap<>();

        for(String key : map.keySet()){
            int x = map.get(key);
            int x_parent = find(x, parent);

            list.putIfAbsent(x_parent, new LinkedList<>());
            list.get(x_parent).addLast(key);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int key : list.keySet()){
            String name = accounts.get(key).get(0);

            LinkedList<String> temp = list.get(key);
            Collections.sort(temp);
            temp.addFirst(name);

            ans.add(temp);
        }

        return ans;
    }
}