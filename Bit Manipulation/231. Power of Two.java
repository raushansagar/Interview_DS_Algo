/* 
    231. Power of Two
    Leetcode Link :- https://leetcode.com/problems/power-of-two/description/
*/

// Approch 1
// Time complexity O(log n)

class Solution1 {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n%2 == 1 || n == 0) return false;

        return isPowerOfTwo(n/2);
    }
}


// Approch 2
// Time complexity O(1)

class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n == 0 || n == Integer.MIN_VALUE) ? false : (n & (n-1)) == 0;
    }
}