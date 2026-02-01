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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //a map to record the index in inOrder
        //pass by value so use int[] to find the index in pOrder
        //return dfs
        Map <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] pIndex = new int[]{0};
        TreeNode result = dfs(0, inorder.length - 1, preorder, inorder, map, pIndex);
        return result;
    }
    //dfs function to construct the result
    //base case left > right, means no more left node to construct
    //construct the current node
    //if left == right, means it's leaf node, return the node
    //find the node.left in left bound, which is left to current index - 1
    //find the right node in the right bound, index + 1 in inorder to right
    //return the root
    public TreeNode dfs(int left, int right, int[] preorder, int[] inorder, Map<Integer, Integer> map, int[] pIndex) {
        //base case
        if (left > right) return null;
        int curr = preorder[pIndex[0]];
        pIndex[0]++;
        TreeNode root = new TreeNode(curr);

        if (left == right) return root;
        int inIndex = map.get(curr);

        root.left = dfs(left, inIndex - 1, preorder, inorder, map, pIndex);
        root.right = dfs(inIndex + 1, right, preorder, inorder, map, pIndex);
        return root;
    }

}