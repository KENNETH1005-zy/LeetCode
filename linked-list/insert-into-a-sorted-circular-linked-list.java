/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        //if head is null
        //while true
        //if inserVal is bigger than prev, or smaller than curr, make the flag true
        //if prev is bigger than curr, insert here
        //if flag insert
        //if not, move to next
        //if not found, add in any where
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;
        boolean flag = false;
        while (true) {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                flag = true;
            }else if (prev.val > curr.val) {
                // InsertVal is either greater than max or smaller than min
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    flag = true;
                }
            }

            if (flag) {
                prev.next = new Node(insertVal, curr);
                return head;
            }
            prev = curr;
            curr = curr.next;

            //if reach the head, break
            if (prev == head) break;
        }
        prev.next = new Node(insertVal, curr);
        return head;
    }
}