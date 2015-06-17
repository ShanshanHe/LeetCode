/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int i = 0; i < inorder.length; i++ ) {
            map.put(inorder[i],i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
    public TreeNode buildTree(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR, HashMap<Integer, Integer> map) {
        if( pL > pR || iL > iR ) return null;
        TreeNode root = new TreeNode(preorder[pL]);
        int index = map.get(preorder[pL]);
        root.left = buildTree(preorder, pL+1, pL+index-iL, inorder, iL, index-1, map);
        root.right = buildTree(preorder, pL+index-iL+1, pR, inorder, index+1, iR, map);
        return root;
    }
}
