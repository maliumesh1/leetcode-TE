class Solution {
      public int[] nodesBetweenCriticalPoints(ListNode head) {
          int[] array = new int[2];
              array[0] = -1;
                  array[1] = -1;
                      if (head == null || head.next == null || head.next.next == null) {
                            return array;
                                }
                                    ListNode first = head;
                                        ListNode second = head.next;
                                            ListNode third = head.next.next;
                                                int index = 2, greater = -1, min = Integer.MAX_VALUE, minDistance = Integer.MAX_VALUE;
                                                    while (third != null) {
                                                          if ((second.val > first.val && second.val > third.val) || (second.val < first.val && second.val < third.val)) {
                                                                  if (greater != -1) {
                                                                            int diff = index - greater;
                                                                                      if (minDistance > diff) {
                                                                                                  minDistance = diff;
                                                                                                            }
                                                                                                                    }
                                                                                                                            greater = index;
                                                                                                                                    if (min > greater) {
                                                                                                                                              min = greater;
                                                                                                                                                      }
                                                                                                                                                            }
                                                                                                                                                                  index++;
                                                                                                                                                                        first = first.next;
                                                                                                                                                                              second = second.next;
                                                                                                                                                                                    third = third.next;
                                                                                                                                                                                        }
                                                                                                                                                                                            array[0] = minDistance == Integer.MAX_VALUE ? -1 : minDistance;
                                                                                                                                                                                                array[1] = (min == Integer.MAX_VALUE || min == greater) ? array[0] : greater - min;
                                                                                                                                                                                                    return array;
                                                                                                                                                                                                      }
                                                                                                                                                                                                      
}