/*
    1829. Maximum XOR for Each Query
    Leetcode Link :- https://leetcode.com/problems/maximum-xor-for-each-query/description/
*/


// Approch 1
// Time complexity O(n * k * m)

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        
        for(int i = n-1; i >= 0; i--){
            int xor = 0;

            for(int j = i; j >= 0; j--){
                xor ^= nums[j];
            }

            int bitMask = 0;
            for(int idx = 0; idx < maximumBit; idx++){
                if((xor & (1 << idx)) == 0){
                    bitMask = bitMask | (1 << idx);
                }
            }

            result[n-i-1] = bitMask;
        }
        

        return result;
    }
}

// Approch 2
// Time complexity O(n * k) k = no of bit
// Space compleixty O(n)

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];

        int[] prefixXor = new int[n];
        prefixXor[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefixXor[i] = prefixXor[i-1] ^ nums[i];
        }

        int k = 0;
        int pow = (1 << maximumBit);
        for(int i = n-1; i >= 0; i--){
            int xor = prefixXor[i];
            int bitMask = 0;

            for(int idx = 0; idx < maximumBit; idx++){
                if((xor & (1 << idx)) == 0){
                    bitMask = bitMask | (1 << idx);
                }
            }

            result[n-i-1] = bitMask;
        }


        return result;
    }
}


// Approch 3
// Time complexity O(n)
// Space compleixty O(n)


class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];

        int[] prefixXor = new int[n];
        prefixXor[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefixXor[i] = prefixXor[i-1] ^ nums[i];
        }

        int pow = (1 << (maximumBit)) - 1;
        for(int i = n-1; i >= 0; i--){
            result[n-i-1] = prefixXor[i] ^ pow;
        }


        return result;
    }
}