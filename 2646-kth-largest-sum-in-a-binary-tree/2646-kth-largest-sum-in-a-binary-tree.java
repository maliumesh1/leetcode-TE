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
    public long kthLargestLevelSum(TreeNode root, int k) {
                          Queue<TreeNode> q = new LinkedList<>();
                                  Queue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());
                                          q.offer(root);
                                                  while(q.size() > 0){
                                                              int level = q.size();
                                                                          long currSum = 0;
                                                                                      for(int i=0;i<level;i++){
                                                                                                      TreeNode curr = q.poll();
                                                                                                                      currSum += curr.val;
                                                                                                                                      if(curr.left != null) q.offer(curr.left);
                                                                                                                                                      if(curr.right != null) q.offer(curr.right);
                                                                                                                                                                  }
                                                                                                                                                                              heap.offer(currSum);
                                                                                                                                                                                      }
                                                                                                                                                                                      
                                                                                                                                                                                              if(k > heap.size()) return -1;
                                                                                                                                                                                              
                                                                                                                                                                                                      int count = 1;
                                                                                                                                                                                                              while(count != k){
                                                                                                                                                                                                                          heap.poll();
                                                                                                                                                                                                                                      count++;
                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                              return heap.poll();
                                                                                                                                                                                                                                                              
                                                                                                                                                                                                                                                                  }
}