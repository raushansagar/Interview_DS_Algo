/*
    Generate Parentheses
    GFG Link :- https://www.geeksforgeeks.org/problems/generate-all-possible-parentheses/1
 */


// Approch 1 
class Solution1 {
    public boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        
        return st.isEmpty();
    }
    public void solve(String curr, int n, ArrayList<String> result){
        if(curr.length() == n){
            if(isValid(curr)) result.add(curr);
            return;
        }
        
        // add open (
        curr += '(';
        solve(curr, n, result);
        curr = curr.substring(0, curr.length()-1);
        
        // add close )
        curr += ')';
        solve(curr, n, result);
        curr = curr.substring(0, curr.length()-1);
    }
    public ArrayList<String> generateParentheses(int n) {
        ArrayList<String> result = new ArrayList<>();
        
        solve("", n, result);
        return result;
    }
}



// Approch 2
class Solution2 {
    public boolean isValid(String s){
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                count++;
            }
            else{
                count--;
            }
            
            if(count < 0) return false;
        }
        
        return count == 0;
    }
    public void solve(String curr, int n, ArrayList<String> result, int open, int close){
        if(open > n/2 || close > n/2){
            return;
        }
        if(curr.length() == n){
            if(isValid(curr)) result.add(curr);
            return;
        }
        
        // add open (
        curr += '(';
        solve(curr, n, result, open+1, close);
        curr = curr.substring(0, curr.length()-1);
        
        // add close )
        curr += ')';
        solve(curr, n, result, open, close+1);
        curr = curr.substring(0, curr.length()-1);
    }
    public ArrayList<String> generateParentheses(int n) {
        ArrayList<String> result = new ArrayList<>();
        
        solve("", n, result, 0, 0);
        return result;
    }
}