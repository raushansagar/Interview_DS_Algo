/*
    Combination Sum III
    Leetcode Link :- https://leetcode.com/problems/combination-sum-iii/description/
*/



// Approch 1 
// Time complexity O(2^9)


class Solution {
    public void solve(int val, int size, int target, List<Integer> curr, List<List<Integer>> result){
        if(target == 0 && curr.size() == size){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || curr.size() >= size || val > 9){
            return;
        }

        curr.add(val);
        solve(val+1, size, target-val, curr, result);

        curr.remove(curr.size()-1);

        solve(val+1, size, target, curr, result);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        solve(1, k, n, new ArrayList<>(), result);
        return result;
    }
}