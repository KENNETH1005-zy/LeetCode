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
        //set a boolean to check if this is the correct position to add the insertVal
        //while true
        //case 1 : bigger than prev and smaller than curr
        //case 2 : at the joint, bigger than prev, or smaller than the curr
        //if boolean is true, add the inserVal in between and the next node is curr
        //move to the next
        //break if prev is head, means already iterate all the nodes in the circle and no valid result was found
         // Case 3: No valid spot found, insert at any position
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        boolean flag = false;
        Node prev = head;
        Node curr = prev.next;

        while (true) {
            
            if (prev.val <= insertVal && insertVal <= curr.val) {
                flag = true;
            }
            else if (prev.val > curr.val){
                if (prev.val <= insertVal || insertVal <= curr.val) {
                    flag = true;
                }
            }

            if (flag) {
                prev.next = new Node(insertVal, curr);
                return head;
            }
            prev = curr;
            curr = curr.next;
            if (prev == head) break;
        }
        // Case 3: No valid spot found, insert at any position
        prev.next = new Node(insertVal, curr);
        return head;
    }
}