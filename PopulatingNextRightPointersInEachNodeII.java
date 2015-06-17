/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if( root == null ) return;
        LinkedList<TreeLinkNode> curr = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
        curr.add(root);
        
        while( !curr.isEmpty() ) {
            TreeLinkNode node = curr.poll();
            node.next = curr.peek();
            if( node.left != null ) next.add(node.left);
            if( node.right != null ) next.add(node.right);
            if( curr.isEmpty() ) {
                curr = next;
                next = new LinkedList<TreeLinkNode>();
            }
        }
    }
}
