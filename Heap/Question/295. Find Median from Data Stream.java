

/*
    295. Find Median from Data Stream
    Leetcode Link :- https://leetcode.com/problems/find-median-from-data-stream/description/
 */



class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>((a, b) -> a - b);
        max = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if(min.size() == max.size()){
            max.add(num);
        }
        else{
            min.add(num);
        }

        balanceHeap();
    }
    
    public void balanceHeap(){
        if(min.isEmpty() || max.isEmpty()) return;
        if(max.peek() <= min.peek()) return;

        int temp1 = max.remove();
        int temp2 = min.remove();

        max.add(temp2);
        min.add(temp1);
    }

    public double findMedian() {
        if(min.size() == max.size()){
            return (min.peek() + max.peek()) / 2.0;
        }

        return max.peek()*1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */