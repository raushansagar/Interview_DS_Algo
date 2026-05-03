

/*
    3. Longest Substring Without Repeating Characters
    Leetcode Link :- https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/


// Approch 2

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;

        int i = 0, j = 0;
        int n = s.length();

        while(i < n){
            char ch = s.charAt(i);

            while(!set.isEmpty() && set.contains(ch)){
                set.remove(s.charAt(j));
                j++;
            }

            max = Math.max(max, (i-j+1));
            
            set.add(ch);
            i++;
        }

        return max;
    }
}
