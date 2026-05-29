
/*  
    3300. Minimum Element After Replacement With Digit Sum

 */




class Solution {
    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int val : nums){

            int sum = 0;

            while(val != 0){
                sum += val%10;
                val = val/10;
            }

            min = Math.min(min, sum);
        }


        return min;
    }
}