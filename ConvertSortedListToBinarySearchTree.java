/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    static ListNode currentHead = null;
    public TreeNode sortedListToBST(ListNode head) {
        currentHead = head;
        int len = getLength(head);
        return sortedListToBST(0, len-1);
    }
    
    int getLength(ListNode head) {
        int length = 0;
        while( head != null ) {
            head = head.next;
            length++;
        }
        return length;
    }
    
    TreeNode sortedListToBST(int start, int end) {
        if( start > end ) return null;
        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(start, mid-1);
        TreeNode root = new TreeNode(currentHead.val);
        currentHead = currentHead.next;
        TreeNode right = sortedListToBST(mid+1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
