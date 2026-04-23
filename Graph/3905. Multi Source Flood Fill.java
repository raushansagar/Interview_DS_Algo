


/*
    3905. Multi Source Flood Fill
    Leetcode Link :- https://leetcode.com/problems/multi-source-flood-fill/description/
*/



// Approch 1
// Time Complexity O()

class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> pq = new LinkedList<>();
        
        for(int[] d : sources){
            int i = d[0];
            int j = d[1];
            int val = d[2];

            grid[i][j] = val;
            vis[i][j] = true;
            pq.add(new int[]{i, j});
        }

        // four directions 
        int[][] dir = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};

        while(!pq.isEmpty()){
            int size = pq.size();

            // current level vist
            Set<List<Integer>> st = new HashSet<>();

            while(size--> 0){
                int[] temp = pq.poll();
                int i = temp[0];
                int j = temp[1];
                
                
                for(int[] d : dir){
                    int i_ = d[0] + i;
                    int j_ = d[1] + j;

                    if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && !vis[i_][j_]){
                        if(!st.contains(Arrays.asList(i_, j_))) st.add(Arrays.asList(i_, j_));
                        grid[i_][j_] = Math.max(grid[i_][j_], grid[i][j]);

                    }
                }
            }

            for(List<Integer> ll : st){
                int i = ll.get(0);
                int j = ll.get(1);
                vis[i][j] = true;
                pq.add(new int[]{i, j});
            }
        }


        return grid;
    }
}