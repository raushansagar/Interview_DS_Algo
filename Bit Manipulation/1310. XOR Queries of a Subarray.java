/*
    1310. XOR Queries of a Subarray
    Leetcode Link :- https://leetcode.com/problems/xor-queries-of-a-subarray/description/
*/



// Approch 1
// Time complexiy O(n^2)

class Solution1{
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];

            int xor = 0;
            for(int k = left; k <= right; k++){
                xor ^= arr[k];
            }

            result[i] = xor;
        }


        return result;
    }   
}

// Approch 2
// Time complexiy O(n)


class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];

        for(int i = 1; i < n; i++){
            prefixXor[i] = arr[i] ^ prefixXor[i-1];
        }

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];

            if(left == 0){
                result[i] = prefixXor[right];
            }
            else{
                result[i] = prefixXor[left-1] ^ prefixXor[right];
            }
        }


        return result;
    }   
}