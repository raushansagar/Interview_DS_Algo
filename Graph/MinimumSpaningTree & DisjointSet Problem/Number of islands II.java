/*
    Number of islands II
*/





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
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int size = rows * cols;
        
        int[] rank = new int[size];
        int[] parent = new int[size];
        
        for(int i = 0; i < size; i++){
            rank[i] = 0;
            parent[i] = i;
        }
        
        int[][] mat = new int[rows][cols];
        
        int noOfLands = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        List<Integer> ans = new ArrayList<>();
        
        for(int[] d : operators){
            int rowIdx = d[0];
            int colIdx = d[1];
            
            if(mat[rowIdx][colIdx] == 1){
                ans.add(noOfLands);
                continue;
            }
            
            mat[rowIdx][colIdx] = 1;
            noOfLands++;
            
            int x = rowIdx * cols + colIdx;
            
            for(int[] path : dir){
                int rowIdx_ = path[0] + rowIdx;
                int colIdx_ = path[1] + colIdx;
                
                if(rowIdx_ >= 0 && rowIdx_ < rows && colIdx_ >= 0 && colIdx_ < cols && mat[rowIdx_][colIdx_] == 1){
                    int y = rowIdx_ * cols + colIdx_;
                    
                    if(find(x, parent) != find(y, parent)){
                        union(x, y, rank, parent);
                        noOfLands--;
                    }
                }
            }
            
            
            ans.add(noOfLands);
        }
        
        
        return ans;
    }
}