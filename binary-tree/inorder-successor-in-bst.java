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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //store the bst tree in a list in the order of inorder
        //return the next one
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        //find the successor
        int index = -1;

        TreeNode node = root;
        
        index = list.indexOf(p) + 1;
        if (index >= list.size() || index == -1) {
            return null;
        }
        return list.get(index);
    }
    public void dfs(TreeNode node, List<TreeNode> list) {
        //base case
        if (node == null) return;

        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }
    
}