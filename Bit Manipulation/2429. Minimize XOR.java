/*
    2429. Minimize XOR
    Leetcode Link :- https://leetcode.com/problems/minimize-xor/description/
 */



// Approch 1 
// Time complexity (k) k = no of set bit 

class Solution {
    public int makeNum(int count, int val){
        int num = 0;

        for(int i = 31; i > 0 && count > 0; i--){
            if((val & (1 << i)) != 0){
                num = num | (1 << i);
                count--;
            }
        }

        for(int i = 0; i < 32 && count > 0; i++){
            if((num & (1 << i)) == 0){
                num = num | (1 << i);
                count--;
            }
        }

        
        return num;
    }
    public int minimizeXor(int num1, int num2) {
        int countBit = Integer.bitCount(num2);
        int x = makeNum(countBit, num1);
        return x;
    }
}
