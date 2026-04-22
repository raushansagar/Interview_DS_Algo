

/*
    2452. Words Within Two Edits of Dictionary
    Leetcode Link :- https://leetcode.com/problems/words-within-two-edits-of-dictionary/?envType=daily-question&envId=2026-04-22
 */




class Solution {
    public int solve(String s, String list){
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != list.charAt(i)){
                count++;
            }
        }

        return count;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < queries.length; i++){
            String s = queries[i];

            for(String list : dictionary){
                if(solve(s, list) <= 2){
                    result.add(s);
                    break;
                }
            }
        }

        return result;
    }
}