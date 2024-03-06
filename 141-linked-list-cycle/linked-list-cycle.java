public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null && second.next != null) {
            if (first == second)
                return true;
            first = first.next;
            second = second.next.next;
        }

        return false;
    }
}