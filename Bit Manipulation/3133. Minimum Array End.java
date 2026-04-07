/*
    3133. Minimum Array End 
    Leetcode Link :- https://leetcode.com/problems/minimum-array-end/submissions/1971813890/
 */


// Approch 1
// Time complexity O(n)


class Solution {
    public long minEnd(int n, int x) {
        long num = x;

        for (int i = 1; i < n; i++) {
            num = (num + 1) | x;
        }

        return num;
    }
}
