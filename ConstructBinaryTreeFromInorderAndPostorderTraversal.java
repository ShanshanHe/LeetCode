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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for( int i = 0; i < inorder.length; i++ ) {
            map.put(inorder[i],i);
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    
    public TreeNode buildTree(int[] inorder, int iL, int iR, int[] postorder, int pL, int pR, HashMap<Integer,Integer> map) {
        if( iL > iR || pL > pR ) return null;
        TreeNode node = new TreeNode( postorder[pR] );
        int index = map.get(postorder[pR]);
        node.left = buildTree(inorder, iL, index-1, postorder, pL, pL+index-iL-1, map);
        node.right = buildTree(inorder, index+1, iR, postorder, pL+index-iL, pR-1, map);
        return node;
    }
}
