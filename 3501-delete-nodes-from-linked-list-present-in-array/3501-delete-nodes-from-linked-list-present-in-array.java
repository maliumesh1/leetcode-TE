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
             public ListNode modifiedList(int[] nums, ListNode head) {
                     int max = 0;
                             for (int i : nums) 
                                         max = Math.max(max, i);
                                         
                                                 boolean [] visited = new boolean[max + 1];
                                                 
                                                         for (int i : nums) visited[i] = true;
                                                         
                                                                 ListNode dummy = new ListNode(-1);
                                                                         dummy.next = head;
                                                                                 ListNode curr = dummy;
                                                                                 
                                                                                         while (head != null) {
                                                                                                     if(head.val <= max && visited[head.val])
                                                                                                                     dummy.next = head.next;
                                                                                                                                 else
                                                                                                                                                 dummy = head;
                                                                                                                                                             head = head.next;
                                                                                                                                                                     }
                                                                                                                                                                     
                                                                                                                                                                             return curr.next;
                                                                                                                                                                                 }
                                                                                                                                                                                 } 