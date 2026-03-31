/*
    191. Number of 1 Bits
    Leetcocde :- https://leetcode.com/problems/number-of-1-bits/description/
*/


// Approch 1
// Time compexity O(log n)

class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while(n > 0){
            count += (n & 1) == 1 ? 1 : 0;
            n = (n >> 1);
        }

        return count;
    }
}

// Approch 2
// Time compexity O(k)  ( k = not of set bit )

class Solution2 {
    public int hammingWeight(int n) {
        int count = 0;

        while(n > 0){
            n = (n & (n-1));
            count++;
        }

        return count;
    }
}