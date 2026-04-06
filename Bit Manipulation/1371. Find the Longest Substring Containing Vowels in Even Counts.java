/*
    1371. Find the Longest Substring Containing Vowels in Even Counts
    Leetcode Link :- https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/
 */






// Approch 1
// Time compleixyt O(n * k) k = no of vowels

class Solution1{
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int bitMask = 0;
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == 'a'){
                bitMask = bitMask ^ (1 << 0);
            }
            else if(ch == 'e'){
                bitMask = bitMask ^ (1 << 1);
            }
            else if(ch == 'i'){
                bitMask = bitMask ^ (1 << 2);
            }
            else if(ch == 'o'){
                bitMask = bitMask ^ (1 << 3);
            }
            else if(ch == 'u'){
                bitMask = bitMask ^ (1 << 4);
            }

            if(map.containsKey(bitMask)){
                result = Math.max(result, i-map.get(bitMask));
            }
            else{
                map.put(bitMask, i);
            }
        }


        return result;
    }
}




// Approch 2
// Time compleixyt O(n) 

class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int bitMask = 0;
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == 'a'){
                bitMask = bitMask ^ (1 << 0);
            }
            else if(ch == 'e'){
                bitMask = bitMask ^ (1 << 1);
            }
            else if(ch == 'i'){
                bitMask = bitMask ^ (1 << 2);
            }
            else if(ch == 'o'){
                bitMask = bitMask ^ (1 << 3);
            }
            else if(ch == 'u'){
                bitMask = bitMask ^ (1 << 4);
            }

            if(map.containsKey(bitMask)){
                result = Math.max(result, i-map.get(bitMask));
            }
            else{
                map.put(bitMask, i);
            }
        }


        return result;
    }
}