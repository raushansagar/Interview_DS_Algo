


/*
    2090. K Radius Subarray Averages
    Leetcode Link :- https://leetcode.com/problems/k-radius-subarray-averages/
 */



class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i = k; i < (n-k); i++){
            int si = i-k;
            int ei = i+k;
            int avg = ei-si+1;
            
            long sum = si == 0 ? prefixSum[ei] : prefixSum[ei] - prefixSum[si-1];
            ans[i] = (int)(1L * sum/avg);
        }

        return ans;
    }
}