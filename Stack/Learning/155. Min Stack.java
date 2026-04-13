/*
    155. Min Stack
    Leetcode Link :- https://leetcode.com/problems/min-stack/description/
 */



// T.C = O(1)
// S.C = O(2N)

class MinStack {

    // inilization LL 
    static class Node{
        Node next;
        int val;

        public Node(int val){
            this.next = null;
            this.val = val;
        }
    }

    // track top element in stact
    Node head;

    // track min element in stack
    Node minVal;

    public MinStack() {
        head = null;
        minVal = null;
    }
    
    public void push(int val) {
        // create new node
        Node newNode = new Node(val);

        // head == null
        if(head == null){
            newNode.next = head;
            head = newNode;

            newNode.next = minVal;
            minVal = newNode;
            return;
        }

        // add node in top
        newNode.next = head;
        head = newNode;

        // update min val
        Node newMinVal = new Node(Math.min(minVal.val, val));
        newMinVal.next = minVal;
        minVal = newMinVal;
    }
    
    public void pop() {

        // LL empty
        if(head == null){
            return;
        }

        // remove top val
        Node temp = head;
        head = head.next;
        temp.next = null;

        // remove top min val
        temp = minVal;
        minVal = minVal.next;
        temp.next = minVal;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return minVal.val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */