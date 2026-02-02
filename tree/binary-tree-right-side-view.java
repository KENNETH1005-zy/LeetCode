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
    public List<Integer> rightSideView(TreeNode root) {
        //record the level of the node
        //if left tree has some thing that exceed tge right level, add it to the result
        //only if the level is equal to the right view size, then add to the result
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();

        dfs(result, 0, root);
        return result;
    }
    public void dfs(List<Integer> result, int level, TreeNode node) {

        if (level == result.size()) {
            result.add(node.val);
        }
        //a collection to collect the children
        List<TreeNode> children = new ArrayList<>();
        children.add(node.right);
        children.add(node.left);
        for (TreeNode current: children) {
            if (current != null) {
                dfs(result, level+1, current);
            }
        }
    }
}