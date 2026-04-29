
/*
    901. Online Stock Span
    Leetcode Link :- https://leetcode.com/problems/online-stock-span/description/
*/



class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price){
        int[] temp = {price, 1};

        while(!st.isEmpty() && st.peek()[0] <= temp[0]){
            temp[1] += st.peek()[1];
            st.pop();
        }

        st.push(temp);
        return temp[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */