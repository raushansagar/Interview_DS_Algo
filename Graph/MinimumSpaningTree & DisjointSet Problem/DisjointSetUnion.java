/*
    Disjoint Set Union
 */




 
// DSU by Rank

public class DisjointSetUnion {

    // find and union by path compression
    public int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }

    // union 
    public void union(int x, int y, int[] parent, int[] rank) {

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
            rank[x_parent] += 1;
        }
    }

    public static void main(String[] args) {
        int n = 4;

        int[] rank = new int[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }
}




// DSU By Size

class DisjointSetUnionSize{

    // find and union by path compression
    public int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }

    // union 
    public void union(int x, int y, int[] parent, int[] size) {

        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if(x_parent == y_parent) return;

        if(size[x_parent] > size[y_parent]){
            parent[y_parent] = x_parent;
            size[x_parent] += size[y_parent];
        }
        else if(size[y_parent] > size[x_parent]){
            parent[x_parent] = y_parent;
            size[y_parent] += size[x_parent];
        }
        else{
            parent[y_parent] = x_parent;
            size[x_parent] += size[y_parent];
        }
    }

    public static void main(String[] args) {
        int n = 4;

        int[] size = new int[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }
}