

/*
    2444. Count Subarrays With Fixed Bounds
    Leetcode Link :- https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/
*/





class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;

        long minIdx = -1;
        long maxIdx = -1;
        long calIdx = -1;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == minK) minIdx = i;
            if(nums[i] == maxK) maxIdx = i;
            if(nums[i] > maxK || nums[i] < minK) calIdx = i;
            
            long val = (Math.min(minIdx, maxIdx) - calIdx);
            ans += val < 0 ? 0 : val;
        }

        return ans;
    }
}