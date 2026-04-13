
// 	-----------------   Implement Of Stack  ------------------------


// 	Implement Stack using Arrays
class myStack {
    int[] stack;
    int top = -1;
    
    public myStack(int n) {
        stack = new int[n];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == stack.length-1;
    }

    public void push(int x) {
        if(isFull()){
            return;
        }
        
        top++;
        stack[top] = x;
    }

    public void pop() {
        if(isEmpty()){
            return;
        }
        
        stack[top] = 0;
        top--;
    }

    public int peek() {
        if(isEmpty()){
            return -1;
        }
        
        return stack[top];
    }
}


// 	Implement Stack using Queue
class MyStack {
    Queue<Integer> q;
    Queue<Integer> h;

    public MyStack() {
        q = new LinkedList<>();
        h = new LinkedList<>();
    }
    
    public void push(int x) {
        h.add(x);

        while(!q.isEmpty()){
            h.add(q.poll());
        }

        while(!h.isEmpty()){
            q.add(h.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty(){
        return q.isEmpty();
    }
}



// 	Implement Stack using LinkedList
class myStack {
    Node head;
    int size;
    
    public myStack(){
        head = new Node(-1);
        size = 0;
    }

    public boolean isEmpty() {
        if(head.data == -1) return true;
        
        return false;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void pop() {
        if(isEmpty()) return;
        
        head = head.next;
        size--;
    }

    public int peek() {
        if(isEmpty()) return -1;
        
        return head.data;
    }

    public int size() {
        return size;
    }
}
