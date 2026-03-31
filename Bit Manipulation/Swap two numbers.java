/* 
    Swap two numbers
    GFG Link :- https://www.geeksforgeeks.org/problems/swap-two-numbers3844/1
*/


class Solution {
    static List<Integer> get(int a, int b) {
        List<Integer> result = new ArrayList<>();
        
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        
        result.add(a);
        result.add(b);
        
        return result;
    }
}