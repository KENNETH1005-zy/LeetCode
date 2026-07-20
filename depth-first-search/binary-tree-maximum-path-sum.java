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
    int result= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }
    public int dfs(TreeNode node) {
        //base case
        if (node == null) {
            return 0;
        }
        //whether the max path is the left
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        result = Math.max(result, left + right + node.val);
        return Math.max(left + node.val, right + node.val);
    }
}