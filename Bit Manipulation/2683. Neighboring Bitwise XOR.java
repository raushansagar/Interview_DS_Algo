/*
    2683. Neighboring Bitwise XOR
    Leetcode Link :- https://leetcode.com/problems/neighboring-bitwise-xor/description/
 */


// Approch 1
// T.C O(n)
// S.C = O(1)

class Solution {
    public boolean checkOriginal(int[] derived, int[] original){
        int n = derived.length;

        for(int i = 1; i < n; i++){
            if(derived[i-1] != (original[i-1] ^ original[i])){
                return false;
            }
        }

        return derived[n-1] == (original[n-1] ^ original[0]);
    }
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        int[] original = new int[n];
        original[0] = 1;

        for(int i = 1; i < n; i++){
            original[i] = original[i-1] ^ derived[i-1];
        }

        if(checkOriginal(derived, original)) return true;

        original[0] = 0;
        for(int i = 1; i < n; i++){
            original[i] = original[i-1] ^ derived[i-1];
        }

        if(checkOriginal(derived, original)) return true;
        return false;
    }
}



// Approch 2
// T.C O(n)
// S.C = O(n)

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;

        for(int val : derived){
            xor ^= val;
        }

        return xor == 0 ? true : false;
    }
}
