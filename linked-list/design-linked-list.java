class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        next = null;
    }
}
class MyLinkedList {
    int size;
    Node head; // 这是一个虚拟头节点 (sentinel node)

    public MyLinkedList() {
        size = 0;
        head = new Node(0); // 虚拟节点，值不重要
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node curr = head;
        // 因为有虚拟头节点，找第 index 个节点需要走 index + 1 步
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;

        
        size++;
        Node pred = head;
        // 找到要插入位置的前驱节点
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        
        Node toAdd = new Node(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        
        size--;
        Node pred = head;
        // 找到要删除位置的前驱节点
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}