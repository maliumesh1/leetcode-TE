class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Adding a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Creating two pointers, fast and slow
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Moving fast pointer to the nth node from the start
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Moving fast and slow pointers together until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Removing the nth node from the end
        slow.next = slow.next.next;

        return dummy.next; // Returning the head of the modified list
    }
}