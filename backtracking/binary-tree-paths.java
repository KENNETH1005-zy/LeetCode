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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, new StringBuilder());
        return result;
    }
    //pre-order
    public void dfs(TreeNode node, List<String> result, StringBuilder sb) {
    if (node == null) return;

    int len = sb.length();
    sb.append(node.val);

    if (node.left == null && node.right == null) {
        result.add(sb.toString());
    } else {
        sb.append("->");
        dfs(node.left, result, sb);
        dfs(node.right, result, sb);
    }

    // Backtrack: remove what we added
    sb.setLength(len); // restore length
    }
}