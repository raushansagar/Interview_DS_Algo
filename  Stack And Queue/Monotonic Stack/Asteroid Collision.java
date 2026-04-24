/*  
    735. Asteroid Collision
    Leetcode Link :- https://leetcode.com/problems/asteroid-collision/
*/







// Approch 1
// Time complexity O(n)
// Space compleixty O(n)


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int val : asteroids){

            while(!st.isEmpty() && st.peek() > 0 && val < 0){
                if(Math.abs(st.peek()) < Math.abs(val)){
                    st.pop();
                }
                else if(Math.abs(st.peek()) == Math.abs(val)){
                    st.pop();
                    val = 0;
                }
                else{
                    val = 0;
                }
            }

            if(val != 0) st.push(val);
        }

        int[] ans = new int[st.size()];
        int idx = st.size()-1;

        while(!st.isEmpty()){
            ans[idx--] = st.pop();
        }

        return ans;
    }
}