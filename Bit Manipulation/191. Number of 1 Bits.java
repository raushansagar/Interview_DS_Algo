/*
    191. Number of 1 Bits
    Leetcocde :- https://leetcode.com/problems/number-of-1-bits/description/
*/


// Approch 1
// Time compexity O(1)

class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        for(int i = 31; i >= 0; i--){
            if(((n >> i) & 1) == 1) count++;
        }

        return count;
    }
}

// Approch 2
// Time compexity O(k)  ( k = not of set bit )

class Solution2 {
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            n = (n & (n-1));
            count++;
        }

        return count;
    }
}


// Approch 3
// Time complexity O(long2 (n))


class Solution3{
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            count += n%2;
            n = n/2;
        }

        return count;
    }
}


// Approch 4
// Time complexity O(1)

class Solution4{
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}