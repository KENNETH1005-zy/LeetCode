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
    //record the smallest node sofar
    Integer smallest;
    public boolean isValidBST(TreeNode root) {
        smallest = null;
        return dfs(root);
    }
    public boolean dfs(TreeNode node) {
        //base case
        if (node == null) {
            return true;
        }
        boolean left = dfs(node.left);
        if (smallest == null || smallest < node.val) {
            smallest = node.val;
        }else {
            return false;
        }
        boolean right = dfs(node.right);
        return left && right;
    }
}