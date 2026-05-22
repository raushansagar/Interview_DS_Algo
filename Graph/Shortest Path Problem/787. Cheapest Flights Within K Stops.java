/*
    787. Cheapest Flights Within K Stops
    Leetcode Link :- https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
*/




class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] e : flights){
            int u = e[0];
            int v = e[1];
            int cost = e[2];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, cost});
        }

        int[] shortestCost = new int[n];
        Arrays.fill(shortestCost, Integer.MAX_VALUE);

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{src, 0});

        shortestCost[src] = 0;
        int level = 0;

        while(!pq.isEmpty() && level <= k){
            int size = pq.size();

            while(size--> 0){

                int[] curr = pq.poll();
                int u = curr[0];
                int cost = curr[1];

                for(int[] e : adj.getOrDefault(u, new ArrayList<>())){
                    int v = e[0];
                    int newCost = cost + e[1];

                    if(newCost < shortestCost[v]){
                        shortestCost[v] = newCost;
                        pq.offer(new int[]{v, newCost});
                    }
                }
            }

            level++;
        }


        return shortestCost[dst] == Integer.MAX_VALUE ? -1 : shortestCost[dst];
    }
}