/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

*/
/*
1. find the middle of the list (quick, slow pointer)
2. reverse the back half part of the list
3. compare
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode last = slow.next;
        while(last.next != null) {
            ListNode tmp = last.next;
            last.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }
        ListNode p = head;
        while(slow.next != null){
            slow = slow.next;
            if(slow.val != p.val) return false;
            p = p.next;
        }
        return true;
    }
}
