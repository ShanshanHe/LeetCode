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
    //recursively
    public void flatten(TreeNode root) {
        if( root == null ) return;
        flatten(root.left);
        flatten(root.right);
        if( root.left == null ) return;
        
        TreeNode p = root.left;
        while( p.right != null ) p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
    */
    
    //iteratively
    public void flatten(TreeNode root) {
        if( root == null ) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while( !st.empty() ) {
            TreeNode node = st.pop();
            if( node.right != null ) st.push(node.right);
            if( node.left != null ) st.push(node.left);
            node.left = null;
            if( !st.empty() ) node.right = st.peek();
        }
    }
}
