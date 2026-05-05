/*
    Longest Repeating Character Replacement
    Leetcode Link :- https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */



class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int[] freq = new int[26];
        int i = 0, j = 0, max = 0, maxFreq = 0;

        // O(n)
        while(i < n){
            freq[(s.charAt(i)-'A')]++;

            maxFreq = Math.max(maxFreq, freq[(s.charAt(i)-'A')]);
            int windowSize = (i-j+1);

            if((windowSize-maxFreq) > k){
                freq[(s.charAt(j)-'A')]--;
                j++;
            }


            max = Math.max(max, (i-j+1));
            i++;
        }


        return max;
    }
}