/*
    Infix To Prefix Notation
    GFG Link :- https://www.geeksforgeeks.org/problems/infix-to-prefix-notation/1
 */



// Approch 1

class Solution {
    public int check(char ch){
        if(ch == '^') return 3;
        if(ch == '*' || ch == '/') return 2;
        if(ch == '+' || ch == '-') return 1;
        
        return -1;
    }
    public String infixToPostfix(String s){
        int n = s.length();
        
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.pop());
                }
                
                st.pop();
            }
            else{
                
                while(!st.isEmpty() && check(st.peek()) > check(ch)){
                    ans.append(st.pop());
                }
                
                while(!st.isEmpty() && check(st.peek()) == check(ch) && ch == '^'){
                    ans.append(st.pop());
                }
                
                st.push(ch);
            }
        }
        
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        
        return ans.toString();
    }
    public char flip(char ch){
        if(ch == '(') return ')';
        if(ch == ')') return '(';
        return ch;
    }
    public String reverseString(String s){
        StringBuilder str = new StringBuilder(s);
        
        int ei = s.length()-1;
        int si = 0;
        
        while(si < ei){
            
            char left = str.charAt(si);
            char right = str.charAt(ei);
            
            // swap
            str.setCharAt(si, flip(right));
            str.setCharAt(ei, flip(left));
            
            si++;
            ei--;
        }
        
        if(si == ei && (str.charAt(si) == '(' || str.charAt(si) == ')')){
            char ch = str.charAt(si);
            str.setCharAt(si, flip(ch));
        }
        
        return str.toString();
    }
    public String infixToPrefix(String s) {
        int n = s.length();
        
        // reverse string O(n)
        s = reverseString(s);
         
        // infix to postfix O(n)
        s = infixToPostfix(s);
        
        // reverse string O(n)
        s = reverseString(s);
        
        return s;
    }
}