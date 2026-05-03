
/*
    50. Pow (x, n)
    Leetcode Link :- https://leetcode.com/problems/powx-n/
*/


// T.C O(log n)

class Solution {
    public double solve(double x, long n){
        if(n <= 0){
            return 1;
        }

        double half = solve(x, n/2);
        if(n%2 == 1){
            return x * half * half;
        }

        return half * half;
    }
    public double myPow(double x, int n) {
        return n > 0 ? solve(x, n) : 1.0/solve(x, -(long)n);
    }
}