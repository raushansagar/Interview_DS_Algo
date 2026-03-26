
/* 
    Check if there exists a subsequence with sum K
    GFG Link :- https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1
 */


// Approch 1
// Time compexity O(2^n);


class Solution {
    public static boolean solve(int idx, int curr, int[] nums, int n, int target){
        if(curr == target){
            return true;
        }
        if(idx >= n || curr > target){
            return false;
        }
        
        boolean take = solve(idx+1, curr+nums[idx], nums, n, target);
        boolean not_take = solve(idx+1, curr, nums, n, target);
        
        return take || not_take;
    }
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
       return solve(0, 0, arr, N, K);
    }
}
