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
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if a node is parent of another node, just return the node
        //starting from root find p and q
        //record the current node as parent and find another one
        result = new TreeNode();
        dfs(root, p, q);
        return result;
    }
    //helper function to dectect whether p or q is found
    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        //base case
        if (node == null) {
            return false;
        }
        int left = dfs(node.left, p, q) ? 1: 0;
        int right = dfs(node.right, p, q) ? 1 : 0;
        int mid = (node == p) || node == q ? 1: 0;
        if ((left + right + mid) >= 2) {
            result = node;
        }
        return left + right + mid > 0;
    }
}