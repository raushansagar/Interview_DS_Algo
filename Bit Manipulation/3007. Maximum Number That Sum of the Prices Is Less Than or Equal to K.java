

/*
    3007. Maximum Number That Sum of the Prices Is Less Than or Equal to K
    Leetcode :- https://leetcode.com/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/description/
*/



// Approch 1
// Time complexity O(log n * log n) = O(log n)^2


class Solution {
    public long[] findPrice(long num){
        if(num == 0) return new long[]{};

        int len = 63 - Long.numberOfLeadingZeros(num) + 1;
        long powBit = (1L << (len-1));
        long[] setBit = new long[len];

        for(int i = 0; i < len-1; i++){
            setBit[i] = powBit/2;
        }

        setBit[len-1] = (powBit == num) ? 1 : (num - powBit) + 1;

        if(powBit != num){
            long[] temp = findPrice(num-powBit);

            for(int i = 0; i < temp.length; i++){
                setBit[i] += temp[i];
            }
        }

        return setBit;
    }
    public long findMaximumNumber(long k, int x) {
        long si = 1;
        long ei = (long)1e15;
        long result = 0;

        
        while(si <= ei){
            long num = si + (ei-si)/2;
            long[] temp = findPrice(num);

            long price = 0;
            for(int i = 0; i < temp.length; i++){
                if((i+1) % x == 0){
                    price += temp[i];
                }
            }

            if(price <= k){
                result = num;
                si = num+1;
            }
            else{
                ei = num-1;
            }
        }
        

        return result;
    }
}
