
// --------------------------  Implement Queue ---------------------------


// 	Implement Queue using Array
class myQueue {
    int[] arr;
    int idx;
    
    // Constructor
    public myQueue(int n) {
        arr = new int[n];
        idx = -1;
    }

    public boolean isEmpty() {
        if(idx < 0){
            return true;
        }
        
        return false;
    }

    public boolean isFull(){
        if(idx >= arr.length-1) return true;
        
        return false;
    }

    public void enqueue(int x) {
        if(idx >= arr.length-1) return;
        
        idx++;
        arr[idx] = x;
    }

    public void dequeue() {
        if(isEmpty()){
            return;
        }
        
        for(int i = 0; i < idx; i++){
            arr[i] = arr[i+1];
        }
        
        arr[idx] = 0;
        idx--;
    }

    public int getFront(){
        if(isEmpty()){
            return -1;
        }
        
        return arr[0];
    }

    public int getRear() {
        if(isEmpty()) return -1;
        
        return arr[idx];
    }
}


// 	Implement Queue using Stack
class MyQueue {
    Stack<Integer> s;
    Stack<Integer> h;

    public MyQueue() {
        s = new Stack<>();
        h = new Stack<>();
    }
    
    public void push(int x) {
        
        while(!s.isEmpty()){
            h.push(s.pop());
        }

        h.push(x);
        while(!h.isEmpty()){
            s.push (h.pop());
        }
    }
    
    public int pop() {
        return s.pop();
    } 
    
    public int peek() {
        return s.peek();
    }
    
    public boolean empty() {
        if(s.isEmpty()){
            return true;
        }

        return false;
    }
}




// 	Implement Queue using LinkedList
class myQueue {
    Node head;
    Node tail;
    int size;
    
    public myQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        
        return false;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);
        
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void dequeue() {
        if(head == null){
            return;
        }
        
        head = head.next;
        size--;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        
        return head.data;
    }

    public int size() {
        return size;
    }
}



