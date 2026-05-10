/*
    76. Minimum Window Substring
    Leetcode Link :- https://leetcode.com/problems/minimum-window-substring/description/
 */




class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m > n) return "";

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for(char ch : t.toCharArray()){
            if(!map.containsKey(ch)) count++;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        String ans = "";

        while(i < n){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if(map.get(ch) == 0) count--;
            }
            else{
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }

            while(count == 0){
                if(ans.length() == 0 || ans.length() > (i-j+1)){
                    ans = s.substring(j, i+1);
                }

                ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if(map.get(ch) == 1) count++;
                j++;
            }

            i++;
        }


        return ans;
    }
}