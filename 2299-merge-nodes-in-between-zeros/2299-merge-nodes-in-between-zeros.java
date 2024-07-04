class Solution {
        public ListNode mergeNodes(ListNode head) {
                // 'curr` pointer to traverse the list
          ListNode curr = head.next;
       // 'updater` pointer points to the node to be updated
           ListNode updater = head;
           // 'sum` variable to store the sum
             int sum = 0;

              while(curr != null){
                if(curr.val == 0){
                  // updating the node value
                 updater.val = sum;
                  if(curr.next != null){
                // it is not the end of the list so 
                   updater = updater.next;
                                                                                                                                                                                    }else{
                                                                                                                                                                                                        // we reached the end of the list
                                                                                                                                                                                                                            updater.next = null;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            // reseting sum after encountering '0`
                                                                                                                                                                                                                                                                            sum = 0;
                                                                                                                                                                                                                                                                                        }else{
                                                                                                                                                                                                                                                                                                        // adding continuous non-zero values
                                                                                                                                                                                                                                                                                                                        sum += curr.val;
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                // moving to the next node
                                                                                                                                                                                                                                                                                                                                                            curr = curr.next;
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                            // returning head of the updated list
                                                                                                                                                                                                                                                                                                                                                                                    return head;
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                        }
