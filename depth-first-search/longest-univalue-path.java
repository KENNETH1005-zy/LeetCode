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
    int result = 0;
    public int longestUnivaluePath(TreeNode root) {
        //longest path for the same value
        //basic is 1
        //if values are all the same
        //the max length is left longest + right longest + current node
        //return the left length + current one(just one) or right length
        dfs(root, root.val);
        return result;
    }
    public int dfs(TreeNode node, int parent) {
        //base case
        //if current node is null return 0
        //only return the length if values are the same
        if (node == null) {
            return 0;
        }
        //the left and right longest from the children
        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);
        
        int leftOne = 0;
        int rightOne = 0;
        if (node.left != null && node.left.val == node.val) {
            leftOne = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightOne = right + 1;
        }
        result = Math.max(result, leftOne + rightOne);
        //return the longest to the last recursion
        return Math.max(leftOne, rightOne);
    }
}