
/*
    846. Hand of Straights
    Leetcode Link :- https://leetcode.com/problems/hand-of-straights/description/
 */




class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for(int i = 0; i < hand.length; i++){
            pq.add(hand[i]);
        }

        while(!pq.isEmpty()){
            
            Queue<Integer> q = new LinkedList<>();
            int size = groupSize;
            int prevVal = -1;

            while(size > 0){
                if(pq.isEmpty()) return false;
                int currVal = pq.remove();

                if(prevVal == currVal){
                    q.add(currVal);
                    continue;
                }

                if(prevVal != -1 && prevVal+1 != currVal) return false;
                prevVal = currVal;
                size--;
            }

            for(int val : q){
                pq.add(val);
            }
        }

        return true;
    }
}