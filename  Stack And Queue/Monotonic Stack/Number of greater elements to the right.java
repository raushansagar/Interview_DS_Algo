/*
    Number of greater elements to the right
    GFG Link :- https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1
*/



// Approch 1 
// T.C = O(n^2)
// S.C = O(1)

class Solution {
    public static int[] count_NGE(int arr[], int indices[]) {
        int n = arr.length;
        int[] next = new int[n];
        
        for(int i = 0; i < n; i++){
            int count = 0;
            
            for(int j = i+1; j < n; j++){
                if(arr[j] > arr[i]) count++;
            }
            next[i] = count;
        }
        
        int[] ans = new int[indices.length];
        for(int i = 0; i < indices.length; i++){
            int idx = indices[i];
            ans[i] = next[idx];
        }
        
        return ans;
    }
}



// Approch 2 
// T.C = O(n log n)
// S.C = O(n)

class Solution {
    static class Pair{
        int val;
        int idx;
        
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public static void merge(int si, int ei, Pair[] nums, int[] count){
        if(si >= ei){
            return;
        }
        
        // divide
        int mid = si + (ei-si)/2;
        
        // left
        merge(si, mid, nums, count);
        
        // right
        merge(mid+1, ei, nums, count);
        
        // merge sorted nums
        sort(si, mid, ei, nums, count);
    }
    public static void sort(int si, int mid, int ei, Pair[] nums, int[] count){
        Pair[] temp = new Pair[ei-si+1];
        int left = si;
        int right = mid+1; 
        int k = 0;
        
        while(left <= mid && right <= ei){
            if((nums[left].val) < (nums[right].val)){
                count[nums[left].idx] += (ei-right+1);
                temp[k++] = nums[left++];
            }
            else{
                temp[k++] = nums[right++];
            }
        }
        
        
        // remaning elements
        while(left <= mid){
            temp[k++] = nums[left++];
        }
        while(right <= ei){
            temp[k++] = nums[right++];
        }
        
        for(int i = 0; i < temp.length; i++){
            nums[si+i] = temp[i];
        }
    }
    public static int[] count_NGE(int arr[], int indices[]) {
        int n = arr.length;
        Pair[] nums = new Pair[n];
        
        for(int i = 0; i < n; i++){
            nums[i] = new Pair(arr[i], i);
        }
        
        
        int[] count = new int[n];
        merge(0, n-1, nums, count);
        
        int[] ans = new int[indices.length];
        for(int i = 0; i < indices.length; i++){
            ans[i] = count[indices[i]];
        }
        
        return ans;
    }
}
