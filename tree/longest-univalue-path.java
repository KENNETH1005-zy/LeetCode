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
    int result = 1;
    public int longestUnivaluePath(TreeNode root) {
        //longest path for the same value
        //basic is 1
        //if values are all the same
        //the max length is left longest + right longest + current node
        //return the left length + current one(just one) or right length
        dfs(root, root.val);
        return result - 1;
    }
    public int dfs(TreeNode node, int parent) {
        //base case
        //if current node is null return 0
        //only return the length if values are the same
        if (node == null) {
            return 0;
        }
        //return to last recursion only if it has the same value as the parent node
        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);
        //if left node or right node has the same value to current node
        //left or right node add 1
        //if left or right node are all the same, return left + right + 1
        //return longer one of left or right to the last recursion
        result = Math.max(result, left + right + 1);
        if (node.val == parent) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}