/*
    Minimum Cost of ropes
    GFG Link :- https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
 */




class Solution {
    public static int minCost(int[] arr) {
        if(arr.length == 1) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for(int val : arr){
            pq.add(val);
        }
        
        int cost = 0;
        while(!pq.isEmpty() && pq.size() >= 2){
            int rop1 = pq.remove();
            int rop2 = pq.remove();
            int newRop = (rop1 + rop2);
            
            pq.add(newRop);
            cost += newRop;
        }
        
        return cost;
    }
}