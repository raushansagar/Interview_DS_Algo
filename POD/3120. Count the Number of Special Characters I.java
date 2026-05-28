
/*
    3120. Count the Number of Special Characters I
*/



// Approch 1

class Solution1 {
    public int numberOfSpecialChars(String word){

        int[] lowerLetter = new int[26];
        int[] upperLetter = new int[26];

        for(int i = 0; i < word.length(); i++){

            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                lowerLetter[ch-'a']++;
            }
            else{
                upperLetter[ch-'A']++;
            }
        }

        int count = 0;

        for(int i = 0; i < 26; i++){
            if(lowerLetter[i] > 0 && upperLetter[i] > 0) count++;
        }

        return count;
    }
}



// Approch 2

class Solution2 {
    public int numberOfSpecialChars(String word){

        Set<Character> set = new HashSet<>();

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            set.add(ch);
        }

        int count = 0;

        for(char ch : set){
            char ch1 = Character.toUpperCase(ch);
            char ch2 = Character.toLowerCase(ch);

            if(set.contains(ch1) && set.contains(ch2)){
                count++;
            }
        }

        return count/2;
    }
}