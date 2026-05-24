/*
    1319. Number of Operations to Make Network Connected
    Leetcode Link :- https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
 */




class Solution {
    public int find(int x, int[] parent){
        if(x == parent[x]) return x;

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
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;

        int[] rank = new int[n];
        int[] parent = new int[n];

        for(int i = 0; i < n; i++){
            rank[i] = 0;
            parent[i] = i;
        }

        int needToMakeConnection = n-1;

        for(int[] e : connections){
            int u = e[0];
            int v = e[1];

            int u_parent = find(u, parent);
            int v_parent = find(v, parent);

            if(u_parent == v_parent){
                continue;
            }

            union(u, v, rank, parent);
            needToMakeConnection--;
        }

        return needToMakeConnection;
    }
}