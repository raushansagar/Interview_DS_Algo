/*
    Postfix to Infix Conversion
    GFG Link Link :- https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1
 */




// Approch 1
// T.C O(n)

class Solution {
    static String postToInfix(String str) {
        int n = str.length();
        
        StringBuilder s = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                if(idx > 0){
                    s.append(',');
                    st.push(idx);
                    idx++;
                }
                
                s.append(ch);
                idx++;
                
            }
            else{
                
                // add operator
                if(!st.isEmpty()){
                    s.setCharAt(st.pop(), ch);
                }
                
                // add brackets
                s.insert((st.isEmpty() ? 0 : st.peek()+1), '(');
                s.append(')');
                idx += 2;
            }
        }
        
        return s.toString();
    }
}
