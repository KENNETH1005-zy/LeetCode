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
    public int maxLevelSum(TreeNode root) {
        //return the level num with the max level sum
        //use a queue to store the level nodes
        //if the sum is bigger update the max
        //return the max sum num
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        int result = Integer.MIN_VALUE;
        int resultLevel = 1;
        int level = 1;
        while (!dq.isEmpty()) {
            int size = dq.size();
            int sum = 0;
            for (int i = 0; i<size; i++) {
                TreeNode node = dq.pollFirst();
                if (node.left != null) dq.addLast(node.left);
                if (node.right != null) dq.addLast(node.right);
                sum += node.val;
            }
            if (sum > result) {
                result = sum;
                resultLevel = level;
            }
            level++;
        }
        return resultLevel;
    }
}