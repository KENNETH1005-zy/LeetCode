/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        return traverse(root, nodes);
    }

    public TreeNode traverse(TreeNode root, TreeNode[] nodes) {
        if(root == null) return null;
        for(TreeNode node:nodes) {
            if(root.val == node.val) return root;
        }
        TreeNode left = traverse(root.left, nodes);
        TreeNode right = traverse(root.right, nodes);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}