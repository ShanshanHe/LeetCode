/**
 * Balanced Binary Tree Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 */
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
    /*
    public boolean isBalanced(TreeNode root) {
        if( root == null ) return true;
        if( Math.abs(depth(root.left) - depth(root.right)) > 1 ) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode node) {
        if( node == null ) return 0;
        return 1+Math.max(depth(node.left),depth(node.right));
    }
    */
    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;
    }
    public int depth(TreeNode root) {
        if( root == null ) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        if( l < 0 || r < 0 || Math.abs(l-r)>1 ) return -1; //pruning
        return 1+Math.max(l,r);
    }
}
