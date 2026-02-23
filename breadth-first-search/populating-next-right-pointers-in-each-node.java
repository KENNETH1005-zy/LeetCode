/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> dq = new LinkedList<>();
        dq.addLast(root);

        while (!dq.isEmpty()) {
            int size = dq.size();

            for (int i = 0; i<size; i++) {
                Node popped = dq.pollFirst();

                if (i < size - 1) {
                    popped.next = dq.peekFirst();
                }else if (i == size - 1){
                    popped.next = null;
                }

                if (popped.left != null) dq.addLast(popped.left);

                if (popped.right != null) dq.addLast(popped.right);
            }

        }
        return root;
    }
}