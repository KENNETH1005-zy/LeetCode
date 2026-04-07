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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        //function to recursivly add the new num to the temp sum
        //add the val of the node from root
        //if reach the leaf, check if the sum is targetSum
        //if it is, add it to the result
        //if not, just return, and do nothing
        if (root == null) return result;
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }
    public void dfs(TreeNode node, int sum, List<Integer> list) {
        //base case
        if (node.left == null && node.right == null) {
            list.add(node.val);
            sum -= node.val;
            if (sum == 0) {
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        list.add(node.val);
        sum -= node.val;
        if (node.left != null) dfs(node.left, sum , list);
        if (node.right != null) dfs(node.right, sum, list);
        list.remove(list.size() - 1);
    }
}