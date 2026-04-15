/*
    Next Smaller Element
    GFG Link :- https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1
*/



// Approch 1
// Time complxity O(n)
// Space complxity O(n)

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        
        for(int i = n-1; i >= 0; i--){
            int val = arr[i];
            
            while(!st.isEmpty() && st.peek() >= val){
                st.pop();
            }
            
            ans.set(i, (st.isEmpty() ? -1 : st.peek()));
            st.push(val);
        }
        
        return ans;
    }
}

