/*
    3097. Shortest Subarray With OR at Least K II
    Leetcode Link :- https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description/
*/

 

// Approch 1
// Time Complexity O(2n)
class Solution {
    public void update(int val, int[] bits, int k){
        for(int i = 0; i < 32; i++){
            if((val & (1 << i)) != 0){
                bits[i] += k;
            }
        }
    }
    public int getDecimalBinary(int[] bits){
        int num = 0;

        for(int i = 0; i < 32; i++){
            if(bits[i] > 0){
                num = num | (1 << i);
            }
        }

        return num;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        int[] bits = new int[32];

        int cumOr = 0;
        int result = Integer.MAX_VALUE;

        // O(2n)
        while(i < n){

            // O(32) = O(1)
            update(nums[i], bits, 1);

            while(j <= i && getDecimalBinary(bits) >= k){
                result = Math.min(result, i-j+1);
                
                // O(32) = O(1)
                update(nums[j], bits, -1);
                j++;
            }

            i++;
        }


        return result == Integer.MAX_VALUE ? -1 : result;
    }
}