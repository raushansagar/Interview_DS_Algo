/*
    40. Combination Sum II
    Leetcode Link :- https://leetcode.com/problems/combination-sum-ii/description/
*/


// Approch 1
// Time complexity O(n * 2^n) extra hashing + duplicates


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> st = new HashSet<>();
    
    public void solve(int idx, int[] nums, int target, List<Integer> list){
        if(target == 0){
            st.add(new ArrayList<>(list));
            return;
        }
        if(idx >= nums.length || target < 0){
            return;
        }

        // take 
        list.add(nums[idx]);
        solve(idx+1, nums, target-nums[idx], list);

        // backtrack
        list.remove(list.size()-1);

        // not take 
        solve(idx+1, nums, target, list);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);

        solve(0, candidates, target, new ArrayList<>());
        for(List<Integer> l : st){
            result.add(new ArrayList<>(l));
        }

        return result;
    }
}



// Approch 2
// Time compelxity O(2^n)


class Solution2{
    List<List<Integer>> result = new ArrayList<>();
    public void solve(int idx, int[] nums, int target, List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(idx >= nums.length || target < 0){
            return;
        }

        for(int i = idx; i < nums.length; i++){
            
            // skip dublications
            if(i > idx && nums[i-1] == nums[i]) continue;
            if(nums[i] > target) break;

            list.add(nums[i]);
            solve(i+1, nums, target-nums[i], list);

            list.remove(list.size()-1);
        }
    } 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);

        solve(0, candidates, target, new ArrayList<>());
        return result;
    }
}