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
    int[] pIndex;
    Map<Integer, Integer> map;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //map to store the index in inorder array
        this.preorder = preorder;
        this.inorder = inorder;
        pIndex = new int[]{0};
        map = new HashMap<>();
        for (int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1);
    }
    public TreeNode dfs(int left, int right) {
        //left and right are bounds
        if (left > right) return null;
        int current = preorder[pIndex[0]];
        TreeNode root = new TreeNode(current);
        pIndex[0]++;
        //leaf node
        if (left == right) return root;
        int iIndex = map.get(current);
        
        root.left = dfs(left, iIndex - 1);
        root.right = dfs(iIndex + 1, right);
        return root;
    }
}