/*
    992. Subarrays with K Different Integers
    Leetcode Link :- https://leetcode.com/problems/subarrays-with-k-different-integers/description/
*/



// Approch 1

class Solution {
    public int findSubArrayLowOrEqualKth(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0, prev = 0;
        int count = 0;

        while(i < n){
            int val = nums[i];
            map.put(val, map.getOrDefault(val, 0) + 1);

            while(map.size() > k){
                val = nums[j];
                map.put(val, map.get(val) - 1);

                if(map.get(val) == 0) map.remove(val);
                j++;
            }

            count += (i-j+1);

            i++;
        }

        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int noOfGoodSubArray = findSubArrayLowOrEqualKth(nums, k) - findSubArrayLowOrEqualKth(nums, k-1);

        return noOfGoodSubArray;
    }
}



// Approch 2

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0, prev = 0;
        int count = 0;

        while(i < n){
            map.put(nums[i], map.getOrDefault(nums[i], 0 ) + 1);

            if(map.size() > k){
                prev = j+1;
            }

            while(map.get(nums[j]) > 1 || map.size() > k){
                map.put(nums[j], map.get(nums[j]) -1);

                if(map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }


            if(map.size() == k){
                count += (j-prev) + 1;
            }

            i++;
        }


        return count;
    }
}