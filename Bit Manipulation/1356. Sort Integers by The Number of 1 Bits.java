/*  
    1356. Sort Integers by The Number of 1 Bits
    Leetcode Link :- https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
 */


// Approch 1
// Time compexity O(n * log n)

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];

        for(int i = 0; i < arr.length; i++){
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);

            if(bitA == bitB){
                return a - b;
            }

            return bitA - bitB;
        });

        for(int i = 0; i < arr.length; i++){
            arr[i] = nums[i];
        }

        return arr;
    }
}


// Aproch 2
// Time compexity O(n * log m)

class Solution2{
    private int countBit(int n){
        int count = 0;

        while(n != 0){
            count += (n & 1) == 1 ? 1 : 0;
            n = n >> 1;
        }

        return count;
    }
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];

        for(int i = 0; i < arr.length; i++){
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            int bitA = countBit(a);
            int bitB = countBit(b);

            if(bitA == bitB){
                return a - b;
            }

            return bitA - bitB;
        });

        for(int i = 0; i < arr.length; i++){
            arr[i] = nums[i];
        }

        return arr;
    }
}