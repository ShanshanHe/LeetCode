/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l1 == null ) return l2;
        if( l2 == null ) return l1;
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode p = dummy;
        while( p.next != null && l2 != null ) {
            if( p.next.val > l2.val ) {
                ListNode tmp = l2;
                l2 = l2.next;
                tmp.next = p.next;
                p.next = tmp;
                p = p.next;
            }
            else p = p.next;
        }
        if( l2 != null ) p.next = l2;
        return dummy.next;
    }
}
