/*
    3478. Choose K Elements With Maximum Sum
    Leetcode Link :- https://leetcode.com/problems/choose-k-elements-with-maximum-sum/description/
 */




class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new int[]{nums1[i], nums2[i], i});
        }

        Collections.sort(list, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long[] ans = new long[n];
        long sum = 0;

        for(int i = 0; i < list.size(); i++){
            int[] temp = list.get(i);
            int curr = temp[0], val = temp[1], idx = temp[2];
            
            if(i > 0 && list.get(i-1)[0] == curr){
                ans[idx] = ans[list.get(i-1)[2]];
            }
            else{
                ans[idx] = sum;
            }

            pq.add(val);
            sum += val;

            while(pq.size() > k){
                sum -= pq.peek();
                pq.remove();
            }
        }


        return ans;
    }
}