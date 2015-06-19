/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
        ** PriorityQueue. 
        ** The elements of the priority queue are ordered according to their natural ordering
        ** or by a comparator provided at the construction time (in this case)
        */
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,
            new Comparator<ListNode>() {
                public int compare(ListNode n1, ListNode n2) {
                    if(n1.val > n2.val) return 1;
                    else if(n1.val == n2.val) return 0;
                    else return -1;
                }
            });
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null ) {
                pq.add(lists[i]);
            }
        }
        
        ListNode head = new ListNode(-1);
        ListNode p = head;
        
        while(pq.size() != 0) {
            ListNode tmp = pq.poll();
            p.next = tmp;
            if(tmp.next != null) pq.add(tmp.next);
            p = p.next;
        }
        return head.next;
    }
}
