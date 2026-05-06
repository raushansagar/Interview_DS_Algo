/*
    Longest Substring with K Uniques
    GFG Link :- https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 */



// Approch 1

class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        int maxLen = -1;
        
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(i < n){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(map.size() > k){
                ch = s.charAt(j);
                map.put(ch, map.get(ch)- 1);
                
                if(map.get(ch) == 0) map.remove(ch);
                j++;
            }
            
            
            if(map.size() == k){
                maxLen = Math.max(maxLen, (i-j+1));
            }
            
            i++;
        }
        
        return maxLen;
    }
}