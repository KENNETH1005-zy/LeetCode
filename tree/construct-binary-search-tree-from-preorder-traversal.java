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
    int index;
    int n;
    int[] preorder;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        n = preorder.length;
        index = 0;
        return dfs(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode dfs(int lower, int upper) {
        //base case
        if (index == n) {
            return null;
        }
        int value = preorder[index];
        //if out of bounds, return null
        if (value < lower || value > upper) {
            return null;
        }
        index++;
        TreeNode current = new TreeNode(value);
        current.left = dfs(lower, value);
        current.right = dfs(value, upper);
        return current;
    }
}