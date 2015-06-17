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
        //bfs + queue
        if( root == null ) return;
        LinkedList<TreeLinkNode> curr = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
        curr.add(root);
        
        while( !curr.isEmpty() ) {
            TreeLinkNode node = curr.poll();
            node.next = curr.peek();
            if( node.left != null && node.right != null ) {
                node.left.next = node.right;
                next.add(node.left);
                next.add(node.right);
            }
            if( curr.isEmpty() ) {
                curr = next;
                next = new LinkedList<TreeLinkNode>();
            }
        }
    }
}
