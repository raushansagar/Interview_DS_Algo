


/*
    827. Making A Large Island
 */



// DSU
class Solution {

    // find and union by path compression
    public int find(int x, int[] parent){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x], parent);
    }

    public void union(int x, int y, int[] size, int[] parent){

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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int l = n * m;
        
        int[] size = new int[l];
        int[] parent = new int[l];

        for(int i = 0; i < l; i++){
            size[i] = 1;
            parent[i] = i;
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){

                if(grid[row][col] == 1){
                    int x = row * m + col;

                    for(int[] d : dir){
                        int row_ = d[0] + row;
                        int col_ = d[1] + col;

                        if(row_ >= 0 && row_ < n && col_ >= 0 && col_ < m && grid[row_][col_] == 1){
                            int y = row_ * m + col_;

                            if(find(x, parent) != find(y, parent)){
                                union(x, y, size, parent);
                            }
                        }
                    }
                }
            }
        }

        int maxLand = 0;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){

                if(grid[row][col] == 0){
                    int x = row * m + col;
                    int currLand = 1;

                    Set<Integer> vis = new HashSet<>();
                    int x_parent = find(x, parent);

                    for(int[] d : dir){
                        int row_ = d[0] + row;
                        int col_ = d[1] + col;

                        if(row_ >= 0 && row_ < n && col_ >= 0 && col_ < m && grid[row_][col_] == 1){
                            int y = row_ * m + col_;
                            int y_parent = find(y, parent);

                            if(x_parent != y_parent && !vis.contains(y_parent)){
                                currLand += size[y_parent];
                                vis.add(y_parent);
                            }
                        }
                    }


                    maxLand = Math.max(maxLand, currLand);
                }
                else{

                    int x = row * m + col;
                    int x_parent = find(x, parent);

                    int currLand = size[x_parent];
                    maxLand = Math.max(maxLand, currLand);
                }
            }
        }

        return maxLand;
    }
}