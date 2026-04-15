/*
    503. Next Greater Element II
    Leetcode :- https://leetcode.com/problems/next-greater-element-ii/description/
*/



// Approch 1
// Time complexity O(n)
// Space complexity O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = n-2; i >= 0; i--){
            st.push(nums[i]);
        }

        for(int i = n-1; i >= 0; i--){
            int val = nums[i];

            while(!st.isEmpty() && st.peek() <= val){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(val);
        }

        return ans;
    }
}