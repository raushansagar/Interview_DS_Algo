/*
    3120. Count the Number of Special Characters I
*/




// Approch 1

class Solution {
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