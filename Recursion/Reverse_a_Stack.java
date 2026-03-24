
/*
    Reverse a Stack
    GFG Link :- https://www.geeksforgeeks.org/problems/reverse-a-stack/1
 */


// Approch 1
class Solution1 {
    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        
        int top = st.pop();
        reverse(st);
        Stack<Integer> temp = new Stack<>();
        
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        st.push(top);
        
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
    }
    public static void reverseStack(Stack<Integer> st) {
        reverse(st);
    }
}



// Approch 2
class Solution2 {
    public static void insertAtButtom(Stack<Integer> st, int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }
        
        int top = st.pop();
        insertAtButtom(st, val);
        
        st.push(top);
    }
    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        
        int top = st.pop();
        reverse(st);
        
        insertAtButtom(st, top);
    }
    public static void reverseStack(Stack<Integer> st) {
        reverse(st);
    }
}
