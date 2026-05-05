/*
    Fruit Into Baskets
    GFG Link :- https://leetcode.com/problems/fruit-into-baskets/description/
 */





class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer,Integer> map = new HashMap<>();

        int i = 0, j = 0, max = 0;

        while(i < n){
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            while(!map.isEmpty() && map.size() > 2){
                map.put(fruits[j], map.get(fruits[j]) - 1);
                if(map.get(fruits[j]) == 0) map.remove(fruits[j]);
                j++;
            }

            max = Math.max(max, (i-j+1));
            i++;
        }

        return max;
    }
}