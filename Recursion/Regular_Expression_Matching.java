
/*  
    10. Regular Expression Matching
    Leetcode Link :- https://leetcode.com/problems/regular-expression-matching/
 */



// Approch 1
// Time complexity O(2^n)

class Solution1 {
    public boolean solve(int i, int j, String s, String p, int n, int m){
        if(j >= m){
            return i >= n;
        }
        
        // Match first Character
        boolean match = (i < n) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // Handle '*' Character
        if(j+1 < m && p.charAt(j+1) == '*'){
            // skip
            return solve(i, j+2, s, p, n, m) 
            // take
            || match && solve(i+1, j, s, p, n, m);
        } 
        else{
            // match first character explore next
            return match && solve(i+1, j+1, s, p, n, m);
        }
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        return solve(0, 0, s, p, n, m);
    }
}