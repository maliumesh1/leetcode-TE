/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head.next==null || head.next.next==null) return; 
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = null;
        ListNode curr = slow.next;
        while (curr!=null) {
            ListNode temp1 = curr.next;
            curr.next = fast;
            fast = curr;
            curr = temp1;
        }
        slow.next = fast;
        fast = head;
        slow = slow.next;
        curr = slow;
        ListNode temp2 = fast.next;
        ListNode temp1 = slow.next;
        while (fast.next!=curr) {
            temp2 = fast.next;
            temp1 = slow.next;
            fast.next = slow;
            slow.next = temp2;
            fast = temp2;
            slow = temp1;
        }
        fast.next = slow;
    }
}