/*
    1423. Maximum Points You Can Obtain from Cards
    Leetcode Link :- 
 */





class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefix = new int[n];

        prefix[0] = cardPoints[0];
        for(int i = 1; i < n; i++) prefix[i] = prefix[i-1] + cardPoints[i];
        if(n == k) return prefix[n-1];

        int i = n-k;
        int j = -1;
        int ans = 0;

        // Time Compelxity O(n)

        while(i < n || j < k){
            int leftPrefix = j >= 0 ? prefix[j] : 0;
            int rightPrefix = i < n ? prefix[n-1]-prefix[i-1] : 0;

            int score = leftPrefix + rightPrefix;
            ans = Math.max(ans, score);

            i++;
            j++;
        }


        return ans;
    }
}