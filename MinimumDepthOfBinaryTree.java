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
    public int minDepth(TreeNode root) {
        //iteratively
        //bfs, the first leaf it encouter is the leaf that has min depth
        if( root == null ) return 0;
        int depth = 1;
        LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        curr.add(root);
        while( !curr.isEmpty() ) {
            TreeNode node = curr.poll();
            if( node.left == null && node.right == null ) return depth;
            if( node.left != null ) next.add(node.left);
            if( node.right != null ) next.add(node.right);
            if( curr.isEmpty() ) {
                depth++;
                curr = next;
                next = new LinkedList<TreeNode>();
            }
        }
        return depth;
    }
    */
    public int minDepth(TreeNode root) {
        //recursively
        if( root == null ) return 0;
        if( root.left == null ) return minDepth(root.right)+1;
        if( root.right == null ) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
