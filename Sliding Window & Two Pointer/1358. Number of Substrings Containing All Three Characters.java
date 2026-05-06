/*
    1358. Number of Substrings Containing All Three Characters
 */




class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i = 0, j = 0;

        int[] ch = new int[3];
        int ans = 0;

        while(i < n){
            int idx = s.charAt(i)-'a';
            ch[idx]++;

            if(ch[0] >= 1 && ch[1] >= 1 && ch[2] >= 1){
                ans += (n-i);
            }

            while(ch[0] >= 1 && ch[1] >= 1 && ch[2] >= 1){
                idx = s.charAt(j)-'a';
                ch[idx]--;
                j++;

                if(ch[0] >= 1 && ch[1] >= 1 && ch[2] >= 1) ans += (n-i);
            }

            i++;
        }


        return ans;
    }
}