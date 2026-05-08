/*
    355. Design Twitter
    Leetcode Link :- https://takeuforward.org/dsa/strivers-a2z-sheet-learn-dsa-a-to-z
*/



class Twitter {

    Map<Integer, List<int[]>> post;
    Map<Integer, Set<Integer>> friend;
    int time;

    public Twitter() {
        post = new HashMap<>();
        friend = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        post.putIfAbsent(userId, new ArrayList<>());
        post.get(userId).add(new int[]{tweetId, time});
        time += 1;
    }
    
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int noOfPost = 10;


        // get user post
        if(post.containsKey(userId)){
            List<int[]> currPost = post.get(userId);

            for(int i = currPost.size()-1; i >= 0 && currPost.size()-i <= 10; i--){
                int[] temp = currPost.get(i);
                pq.add(new int[]{temp[0], temp[1]});
            }
        }
        

        // get friends post
        for(int friends : friend.getOrDefault(userId, new HashSet<>())){
            if(!post.containsKey(friends)) continue;

            List<int[]> currPost = post.get(friends);
            for(int i = currPost.size()-1; i >= 0 && currPost.size()-i <= 10; i--){
                int[] temp = currPost.get(i);
                pq.add(new int[]{temp[0], temp[1]});
            }
        }

        while(!pq.isEmpty() && noOfPost > 0){
            int[] temp = pq.remove();
            ans.add(temp[0]);
            noOfPost--;
        }

        return ans;
    }   
    
    public void follow(int followerId, int followeeId) {
        friend.putIfAbsent(followerId, new HashSet<>());
        friend.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(friend.containsKey(followerId)){
            friend.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */