/*
    Count number of Nice subarrays
    Leetcode Link :- https://takeuforward.org/dsa/strivers-a2z-sheet-learn-dsa-a-to-z
 */



class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int oddCount = 0, noOfSub = 0;

        for(int i = 0; i < nums.length; i++){
            oddCount += (nums[i]%2 == 1 ? 1 : 0);

            if(map.containsKey(oddCount-k)){
                noOfSub += map.get(oddCount-k);
            }

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }


        return noOfSub;
    }
}