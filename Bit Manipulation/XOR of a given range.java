/*
    XOR of a given range
    GFG Link :- https://www.geeksforgeeks.org/problems/xor-of-a-given-range/1
 */





// Approch 1
class Solution {
    public int getXor(int[] nums, int a, int b) {
        int n = nums.length;
        int xor = 0;
        
        for(int i = a; i <= b; i++){
            xor ^= nums[i];
        }
        
        
        return xor;
    }
}