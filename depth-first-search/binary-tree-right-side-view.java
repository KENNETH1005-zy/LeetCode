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
    //list to store the result
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        //use the size of result as the level index
        dfs(root, 0);
        return result;
    }
    public void dfs(TreeNode node, int level) {
        if (level == result.size()) {
            result.add(node.val);
        }
        if (node.right != null) dfs(node.right, level + 1);
        if (node.left != null) dfs(node.left, level + 1);
    }
}