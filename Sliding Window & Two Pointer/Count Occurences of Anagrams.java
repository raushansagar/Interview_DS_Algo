/*
    Count Occurences of Anagrams
    GFG Link :- https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
 */




// User function Template for Java

class Solution {
    int search(String pat, String txt) {
        int n = txt.length();
        int k = pat.length();
        
        int[] patFreq = new int[26];
        int count = 0;
        
        for(char ch : pat.toCharArray()){
            
            if(patFreq[ch-'a'] == 0) count++;
            patFreq[ch-'a']++;
        }
        
        int i = 0, j = 0;
        int ans = 0;
        
        while(i < n){
            int idx = txt.charAt(i)-'a';
            patFreq[idx]--;
            
            if(patFreq[idx] == 0) count--;
            
            while((i-j+1) == k){
                ans += (count == 0 ? 1 : 0);
                
                int leftIdx = txt.charAt(j)-'a';
                patFreq[leftIdx]++;
                
                if(patFreq[leftIdx] == 1) count++;
                j++;
            }
            
            
            i++;
        }
        
        
        
        return ans;
    }
}