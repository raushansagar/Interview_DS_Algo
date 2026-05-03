/*
    460. LFU Cache
    Leetcode Link :- https://leetcode.com/problems/lfu-cache/description/
*/




// Approch 1
// Time Compleixty = O(1)
// Time complexity functions get and put = O(1)

class LFUCache {

    class Node{
        int key, val, freq;
        Node next, prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class Dll{
        
        Node head, tail;
        int size;

        Dll(){
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
            size = 0;
        }


        void addFirst(Node node){
            Node next = head.next;

            head.next = node;
            node.prev = head;

            node.next = next;
            next.prev = node;

            size++;
        }

        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast(){
            if(size > 0){
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    Map<Integer, Node> keyMap;
    Map<Integer, Dll> freqMap;
    int minFreq, cap;
    
    

    public LFUCache(int capacity) {
        minFreq = 0;
        cap = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;

        Node node = keyMap.get(key);
        update(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            node.val = value;
            update(node);
        }
        else{
            if(keyMap.size() == cap){
                Dll list = freqMap.get(minFreq);
                Node node = list.removeLast();
                keyMap.remove(node.key);
            }
            
            Node node = new Node(key, value);
            minFreq = 1;

            freqMap.putIfAbsent(1, new Dll());
            freqMap.get(1).addFirst(node);

            keyMap.put(key, node);
        }
    }
    public void update(Node node){
        Dll list = freqMap.get(node.freq);
        list.remove(node);

        if(node.freq == minFreq && list.size == 0){
            minFreq++;
        }
        node.freq++;

        freqMap.putIfAbsent(node.freq, new Dll());
        freqMap.get(node.freq).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */