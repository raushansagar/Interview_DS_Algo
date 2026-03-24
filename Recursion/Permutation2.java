/*
    47. Permutations II
    Leetcode : https://leetcode.com/problems/permutations-ii/description/
*/


// Approch 1
// Time complexity O (n! * n)

import  java.util.*;
class Solution {
    public void solve(Map<Integer, Integer> map, List<Integer> curr, int n, List<List<Integer>> result){
        if(curr.size() >= n){
            result.add(new ArrayList<>(curr));
            return;
        }

       
        for(int key : map.keySet()){
            if(map.get(key) == 0) continue;

            curr.add(key);
            map.put(key, map.getOrDefault(key, 0) - 1);

            // recursive call
            solve(map, curr, n, result);

            // backtrack
            curr.remove(curr.size()-1);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        solve(map, new ArrayList<>(), nums.length, result);
        return result;
    }
}



// Approch 2
// 
class Solution2 {
    List<List<Integer>> result = new ArrayList<>();
    public void solve(int idx, int[] nums){
        if(idx >= nums.length){
            List<Integer> temp = new ArrayList<>();
            
            for(int i = 0; i < nums.length; i++){
                temp.add(nums[i]);
            }
            result.add(temp);
            return;
        }

        Set<Integer> st = new HashSet<>();
        for(int i = idx; i < nums.length; i++){
            if(st.contains(nums[i])) continue;
            st.add(nums[i]);

            swap(nums, i, idx);
            solve(idx+1, nums);

            swap(nums, i, idx);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        solve(0, nums);
        return result;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}