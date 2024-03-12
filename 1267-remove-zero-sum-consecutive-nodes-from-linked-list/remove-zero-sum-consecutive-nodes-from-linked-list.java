class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null)
        return head;
        ListNode current=head;
        int sum=0;
        while(current!=null) 
        {
            sum+=current.val;
            if(sum==0) 
            {
                head=current.next;
                return removeZeroSumSublists(head);
            }
            current=current.next;
        }
        head.next=removeZeroSumSublists(head.next);
        return head;
    }
}