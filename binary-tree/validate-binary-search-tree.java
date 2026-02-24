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
    public boolean isValidBST(TreeNode root) {
        //cause java int is pass by value, we need a variable that can pass in reference,
        //which can retrive pass in reference
        Integer[] curr = new Integer[1];
        curr[0] = null;
        return dfs(root, curr);
    }
    public boolean dfs(TreeNode node, Integer[] curr) {
        //base case
        if (node == null) return true;

        boolean left = dfs(node.left, curr);
        //if prev node is smaller than current, means this is a valid node
        //update the curr node
        if (curr[0] == null || curr[0] < node.val) {
            curr[0] = node.val;
        }else {
            return false;
        }
        boolean right = dfs(node.right, curr);

        return left && right;
    }
}