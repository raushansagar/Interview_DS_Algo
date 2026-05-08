package Heap.Question;

/*
    621. Task Scheduler
    Leetcode Link :- https://leetcode.com/problems/task-scheduler/description/
*/




class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int val : tasks){
            map.put(val , map.getOrDefault(val, 0) + 1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            pq.add(new int[]{key, freq});
        }

        int ans = 0;
        while(!pq.isEmpty()){

            Queue<int[]> q = new LinkedList<>();
            int task = n+1;
            int count = 0;

            while(task--> 0){

                if(pq.isEmpty()){
                    if(q.isEmpty()) break;

                    count++;
                    continue;
                }

                int[] temp = pq.remove();
                temp[1]--;
                count++;

                if(temp[1] != 0){
                    q.add(temp);
                }
            }

            ans += count;

            for(int[] temp : q){
                pq.add(temp);
            }
        }


        return ans;
    }
}