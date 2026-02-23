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
    //global result
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //to find the common descendant
        dfs(root, p, q);
        return result;
    }
    //a fuction that can determin whether the left or the right or the current node is a valid result
    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        //base case, if not find the result, traverse to null return false
        if (node == null) return false;
        
        int left = dfs(node.left, p, q) ? 1 : 0;
        int right = dfs(node.right, p, q) ? 1 : 0;

        int mid = (node.val == p.val || node.val == q.val) ? 1:0;

        if (left + right + mid >= 2) {
            result = node;
        }
        //return true if any of it has valid node
        return left + right + mid > 0;
    }
}