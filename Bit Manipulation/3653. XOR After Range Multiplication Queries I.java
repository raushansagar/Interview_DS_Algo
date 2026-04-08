/*
    3653. XOR After Range Multiplication Queries I
    Leetcode Link :- https://leetcode.com/problems/xor-after-range-multiplication-queries-i/description/?envType=daily-question&envId=2026-04-08
*/




// Approch 1 
// Time complexity O(q * n)

class Solution {
    int mod = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int xor = 0;
        int n = nums.length;

        // O(q)
        for(int[] d : queries){
            int l = d[0];
            int r = d[1];
            int k = d[2];
            int v = d[3];

            // Skip
            if(v == 1) continue; 

            // O(n) max = n
            while(l <= r){
                nums[l] = (int)((nums[l]* 1L *v) % mod);
                l += k;
            }
        }
        
        // O(n)
        for(int val : nums){
            xor ^= val;
        }

        // Total time compleixty O(Q * n + n) = O(q * n)
        return xor;
    }
}