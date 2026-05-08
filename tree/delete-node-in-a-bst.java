/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        //find the deletedNode
        //detach and attach the rest of the target
        //return the new tree

        //if the root is null, or the root is the target
        if (root == null) return null;
        if (root.val == key) return helper(root);
        //in case the root is the deleted node, use dummy node
        TreeNode dummy = root;

        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                }else {
                    root = root.left;
                }
                
            }

            else if (root.val < key) {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                }else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public TreeNode helper(TreeNode node) {
        //if one if the children is null return another one
        //find the right child of the current node
        //find the right most in the left tree
        //make the rightmost's right is the right child
        //return the current's left
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;

        TreeNode rightChild = node.right;
        TreeNode rightMost = rightMost(node.left);
        rightMost.right = rightChild;
        return node.left;
    }
    public TreeNode rightMost(TreeNode node) {
        if (node.right == null) return node;
        return rightMost(node.right);
    }
}