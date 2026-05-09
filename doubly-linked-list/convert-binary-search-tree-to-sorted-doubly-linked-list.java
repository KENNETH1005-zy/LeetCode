/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        //use a first and last node
        //dfs to connect all the nodes
        if (root == null) return null;
        dfs(root);
        first.left = last;
        last.right = first;
        return first;
    }
    public void dfs(Node node) {
        //base case
        if (node == null) return;
        //inorder traverse
        dfs(node.left);
        //connect to the current node
        if (last != null) {
            last.right = node;
            node.left = last;
        }else {
            first = node;
        }
        last = node;
        dfs(node.right);
    }
}