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
    //global sum to record the overall max sum
    int[] result;
    public int maxPathSum(TreeNode root) {
        result= new int[1];
        result[0] = Integer.MIN_VALUE;
        dfs(root);
        return result[0];
    }

    //find the max sum in each recursion
    public int dfs(TreeNode node) {
        //base case
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        //include the current node
        result[0] = Math.max(result[0], node.val + left + right);
        //or exclude chose the bigger path between left and right
        return Math.max(node.val + left, node.val + right);

    }
}