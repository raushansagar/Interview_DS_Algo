/*
    2104. Sum of Subarray Ranges
    Leetcode Link :- https://leetcode.com/problems/sum-of-subarray-ranges/description/
 */




class Solution {
    public int[] getMinNSL(int[] nums, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){

            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }


        return ans;
    }
    public int[] getMinNSR(int[] nums, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }


        return ans;
    }
    public int[] getMaxNSL(int[] arr, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }
    public int[] getMaxNSR(int[] arr, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] minNSL = new int[n];
        int[] minNSR = new int[n];
        int[] maxNSL = new int[n];
        int[] maxNSR = new int[n];

        minNSL = getMinNSL(nums, n);
        minNSR = getMinNSR(nums, n);
        maxNSL = getMaxNSL(nums, n);
        maxNSR = getMaxNSR(nums, n);

        long max = 0;
        long min = 0;
        for(int i = 0; i < n; i++){
            int noMinSub = (i - minNSL[i]) * (minNSR[i] - i);
            int noMaxSub = (i - maxNSL[i]) * (maxNSR[i] - i);

            min += (1L * nums[i] * noMinSub);
            max += (1L * nums[i] * noMaxSub);
        }

        return (max-min);
    }
}