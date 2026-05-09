/*
    703. Kth Largest Element in a Stream
    Leetcode Link :- https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */



class KthLargest {

    PriorityQueue<Integer> pq;
    int kth;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a, b) -> a - b);

        for(int val : nums){
            pq.add(val);

            if(pq.size() > k){
                pq.remove();
            }
        }

        kth = k;
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size() > kth){
            pq.remove();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */