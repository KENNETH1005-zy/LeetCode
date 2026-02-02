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
    public List<List<Integer>> levelOrder(TreeNode root) {
       //a linkedlist to store the val
       //iterate in the size, add the node val to the result
       if (root == null) return new ArrayList<>();
       Deque<TreeNode> dq = new LinkedList<>();
       dq.add(root);
       List<List<Integer>> result = new ArrayList<>();
       while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> single = new ArrayList<>();
            for (int i = 0; i<size; i++) {
                TreeNode current = dq.poll();
                if (current.left != null) dq.add(current.left);
                if (current.right != null) dq.add(current.right);
                single.add(current.val);
            }
            result.add(new ArrayList<>(single));
       }
       return result;
    }
}