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
    int[] result;
    public int diameterOfBinaryTree(TreeNode root) {
        //for each node there is two options
        //getting the left path or getting the right path,
        //or combining the left and right path
        result = new int[]{0};
        dfs(root);
        return result[0];
    }

    public int dfs(TreeNode root) {
        //base case 
        if (root == null) {
            return -1;
        }
        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);

        result[0] = Math.max(result[0], leftLength + rightLength + 2);
        return Math.max(leftLength, rightLength) + 1;
    }
}