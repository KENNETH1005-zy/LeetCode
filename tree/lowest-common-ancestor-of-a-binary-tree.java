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
    //global result node
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        dfs(root, p, q);
        return result;
    }
    //helper function to dectect if hit p or q, 
    //in left and right and mid node, only contains one, return true, means find it
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null) {
            return false;
        }
        int left = dfs(root.left, p, q) ? 1 : 0;
        int right = dfs(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;

        if ((left + right + mid) >= 2) {
            result = root;
        }
        return left + right + mid > 0;
    }

}