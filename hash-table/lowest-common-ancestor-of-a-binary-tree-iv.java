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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        return dfs(root, nodes);
    }
    public TreeNode dfs(TreeNode root, TreeNode[] nodes) {
        //base case
        if (root == null) return null;
        //if root is equal to any of the nodes return the current root
        for(TreeNode node: nodes) {
            if (root.val == node.val) {
                return root;
            }
        }
        TreeNode left = dfs(root.left, nodes);
        TreeNode right = dfs(root.right, nodes);
        //if left and right are both not null, means current root is LCA
        if (left != null && right != null) return root;
        //any one of the node in left and right is not null, then give it to the prev recursion
        return left == null ? right: left;
    }
}