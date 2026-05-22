/*
    743. Network Delay Time
    Leetcode Link :- https://leetcode.com/problems/network-delay-time/description/
*/



class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] d : times){
            int u = d[0];
            int v = d[1];
            int time = d[2];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, time});
        }

        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{k, 0});
        minTime[k] = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size--> 0){
                int[] curr = q.poll();
                int u = curr[0];
                int time = curr[1];

                if(minTime[u] < time) continue;

                for(int[] e : adj.getOrDefault(u, new ArrayList<>())){
                    int v = e[0];
                    int updatedTime = e[1] + time;
                    
                    if(updatedTime < minTime[v]){
                        minTime[v] = updatedTime;
                        q.offer(new int[]{v, updatedTime});
                    }
                }
            }
        }

        int time = Integer.MIN_VALUE;
        for(int i = 1; i < minTime.length; i++){
            time = Math.max(time, minTime[i]);
        }

        return time == Integer.MAX_VALUE ? -1 : time;
    }
}