//use  node class
//store the head and tail
//make the least used one at the head, and the new at the tail
//use map to store the node
class Node {
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}
class LRUCache {
    //map to store the key and the value
    //once get or put, set it as most recently used
    //evict the least recently used one
    //map to store the node, for relationship
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, - 1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        //o1
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        //o1
        if (map.containsKey(key)) {
            Node current = map.get(key);
            remove(current);
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        add(node);
        if (map.size() > capacity) {
            Node delete = head.next;
            remove(delete);
            map.remove(delete.value);
        }


    }
    //add function
    //remove function
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void add(Node node) {
        //add to the end, which means add to the just front of tail
        Node tailFront = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = tailFront;
        tailFront.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */