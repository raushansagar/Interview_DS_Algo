/*
    1915. Number of Wonderful Substrings
    Leetcode Link :- https://leetcode.com/problems/number-of-wonderful-substrings/description/
 */


// Time complexity O(n * 10)

class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);

        long result = 0;
        int cumXor = 0;

        for(char ch1 : word.toCharArray()){
            int shift = ch1-'a';

            cumXor ^= (1 << shift);
            result += map.getOrDefault(cumXor, 0L);

            for(char ch2 = 'a'; ch2 <= 'j'; ch2++){
                shift = ch2-'a';
                int cumXor2 = (cumXor ^ (1 << shift));

                result += map.getOrDefault(cumXor2, 0L);
            }

            map.put(cumXor, map.getOrDefault(cumXor, 0L) + 1);
        }
        


        return result;
    }
}