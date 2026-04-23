/*
    907. Sum of Subarray Minimums
    Leetcode Link :- https://leetcode.com/problems/sum-of-subarray-minimums/description/
 */




// Approch 1
// Time complexity O(n)
// Space compexity O(n)

class Solution {
    public int[] getNSL(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] num = new int[n];

        for(int i = 0; i < n; i++){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                num[i] = -1;
            }
            else{
                num[i] = st.peek();
            }

            st.push(i);
        }

        return num;
    }
    public int[] getNSR(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] num = new int[n];

        for(int i = n-1; i >= 0; i--){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                num[i] = n;
            }
            else{
                num[i] = st.peek();
            }

            st.push(i);
        }

        return num;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        int[] NSL = new int[n];
        int[] NSR = new int[n];

        NSL = getNSL(arr, n);
        NSR = getNSR(arr, n);

        long sum = 0;
        for(int i = 0; i < n; i++){
            int times = (i - NSL[i]) * (NSR[i] - i);
            sum = (sum + (1L * times * arr[i])) % mod;
        }

        return (int)sum;
    }
}


// Approch 2
// Time complexity O(n^3)
// Space compexity O(1)

class Solution2{
    int mod = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int min = Integer.MAX_VALUE;

                for(int k = i; k <= j; k++){
                    min = Math.min(min, arr[k]);
                }

                sum = (int)(1L * sum + min) % mod;
            }
        }

        return sum;
    }
}