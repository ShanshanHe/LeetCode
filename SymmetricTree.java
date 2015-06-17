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
    // recursively tree traversal
    public boolean isSymmetric(TreeNode root) {
        if( root == null ) return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if( l == null && r == null ) return true;
        else if ( l == null || r == null ) return false;
        
        return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
    */
    
    //iteratively tree traversal
    public boolean isSymmetric(TreeNode root) {
        if( root == null ) return true;
        //if( (root.left == null && root.right != null) || (root.left != null && root.right == null) ) return false;
        LinkedList<TreeNode> l = new LinkedList<TreeNode>();
        LinkedList<TreeNode> r = new LinkedList<TreeNode>();
        l.add(root.left);
        r.add(root.right);
        while( !l.isEmpty() && !r.isEmpty() ) {
            TreeNode tmp1 = l.poll();
            TreeNode tmp2 = r.poll();
            if ( (tmp1 == null && tmp2 != null) || (tmp1 != null && tmp2 == null) ) return false;
            if( tmp1 != null ) {
                if( tmp1.val != tmp2.val ) return false;
                l.add(tmp1.left);
                l.add(tmp1.right);
                r.add(tmp2.right);
                r.add(tmp2.left);
            }
        }
        return true;
    }
}
