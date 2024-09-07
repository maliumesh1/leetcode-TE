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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        ListNode head2 = head;
        return helper(head, root, head2);
    }

    public boolean helper(ListNode head, TreeNode root, ListNode head2) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        boolean l1 = false;
        boolean l2 = false;
        boolean left = false;
        boolean right = false;
        if (head.val == root.val) {
            l1 = helper(head.next, root.left, head2);
            l2 = helper(head.next, root.right, head2);
        }
        if (!(l1 || l2) && (head == head2)) {
            left = helper(head, root.left, head2);
            right = helper(head, root.right, head2);
        }
        return left || right || l1 || l2;
    }

}