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
    List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, new StringBuilder());
        return result;
    }
    public void dfs(TreeNode node, StringBuilder current) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            current.append(String.valueOf(node.val));
            result.add(current.toString());
            return;
        }
        int len = current.length();
        current.append(String.valueOf(node.val));
        current.append("->");
        dfs(node.left, current);
        dfs(node.right, current);
        //backtracking
        current.setLength(len);
    }
}