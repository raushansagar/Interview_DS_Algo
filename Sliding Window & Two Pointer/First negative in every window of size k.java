/*
    First negative in every window of size k
    Leetcode Link :- https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
*/




class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        int n = arr.length;
        int i = 0, j = 0;
        
        while(j < n){
            if(arr[j] < 0) q.add(arr[j]);
            
            while((j-i+1) > k){
                if(arr[i] < 0) q.remove();
                i++;
            }
            
            if((j-i+1) == k && !q.isEmpty()){
                ans.add(q.peek());
            }
            else if((j-i+1) == k && q.isEmpty()){
                ans.add(0);
            }
            
            j++;
        }
        
        return ans;
    }
}