/* 
    2275. Largest Combination With Bitwise AND Greater Than Zero
    Leetcode Link :- https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/
 */




// Approch 1
// Time compelixty O(2^n * n)

class Solution1{
    int result = 0;
    public int computeAnd(List<Integer> list){
        if(list.size() == 0) return 0;
        if(list.size() == 1) return 1;

        int ans = list.get(0);
        for(int i = 1; i < list.size(); i++){
            ans = ans & list.get(i);
        }

        return ans > 0 ? list.size() : 0;
    }
    public void solve(int idx, List<Integer> list, int[] nums){
        if(idx >= nums.length){
            result = Math.max(computeAnd(list), result);
            return;
        }

        list.add(nums[idx]);
        solve(idx+1, list, nums);

        list.remove(list.size()-1);
        solve(idx+1, list, nums);
    }
    public int largestCombination(int[] candidates) {
        solve(0, new ArrayList<>(), candidates);

        return result;
    }
}


// Approch 2
// Time complexity O(2^n)

class Solution2{
    int result = 0;
    public void solve(int idx, int xor, int size, int[] nums){
        if(result < size && xor > 0) result = Math.max(result, size);
        if(idx >= nums.length || (size + nums.length-idx) <= result) return;

        // take 
        solve(idx+1, (xor&nums[idx]), size+1, nums);

        // not take
        solve(idx+1, xor, size, nums);
    }
    public int largestCombination(int[] candidates) {
        solve(1, candidates[0], 1, candidates);

        return result;
    }
}


// Approch 3
// Time complexity O(k * n) k = no of bit 32
// final time complexity O(n)

class Solution3{
    public int largestCombination(int[] candidates) {
        int size = 1;
        
        

        for(int i = 30; i >= 0; i--){
            int len = 0;

            for(int j = 0; j < candidates.length; j++){
                if((candidates[j] & (1 << i)) != 0){
                    len++;
                }
            }

            size = Math.max(size, len);
        }

        return size;
    }
}