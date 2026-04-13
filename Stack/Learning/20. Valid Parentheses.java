/*
    20. Valid Parentheses
    Leetcode Link :- https://leetcode.com/problems/valid-parentheses/
*/



// Time Complexity O(n)
// Space Compleixity O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && (st.peek() == '(' && ch == ')' || st.peek() == '[' && ch == ']' || st.peek() == '{' && ch == '}')){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}
