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
    public TreeNode createBinaryTree(int[][] descriptions) {
        //use map to store the val and its node
        // a set for children node and a set for parent node
        //find the one not contains in the child set
        Set<Integer> parents = new HashSet<>();
        Set<Integer> children = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();

        for (int[] d: descriptions) {
            int parent = d[0];
            int child = d[1];
            boolean isLeft = d[2] == 1;
            
            if (!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }

            if (!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }

            if(isLeft) {
                map.get(parent).left = map.get(child);
            }else {
                map.get(parent).right = map.get(child);
            }

            parents.add(parent);
            children.add(child);
        }
        for (Map.Entry<Integer, TreeNode> entry: map.entrySet()) {
            if (!children.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}