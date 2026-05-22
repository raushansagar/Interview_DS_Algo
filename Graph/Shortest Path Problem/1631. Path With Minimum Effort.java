/*
    1631. Path With Minimum Effort
    Leetcode Link :- https://leetcode.com/problems/path-with-minimum-effort/description/
 */




class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] effort = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        effort[0][0] = 0;

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!pq.isEmpty()){

            int[] temp = pq.poll();
            int i = temp[0];
            int j = temp[1];
            int currEffort = temp[2];

            if(effort[i][j] < currEffort) continue;

            for(int[] d : dir){
                int i_ = d[0] + i;
                int j_ = d[1] + j;

                if(i_ < 0 || i_ >= n || j_ < 0 || j_ >= m) continue;
                int newEffort = Math.max(Math.abs(heights[i][j] - heights[i_][j_]), currEffort);

                if(newEffort < effort[i_][j_]){
                    effort[i_][j_] = newEffort;
                    pq.add(new int[]{i_, j_, newEffort});
                }
            }
        }
        

        return effort[n-1][m-1];
    }
}