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
                  private List<TreeNode> ordered = new ArrayList<>();
                      public TreeNode balanceBST(TreeNode root) {
                              inOrder(root);
                                      return bst(0, ordered.size() - 1);
                                          }
                                              private TreeNode bst(int start, int end) {
                                                      if (start > end)    return null;
                                                              else if (start == end) {
                                                                          TreeNode ret = ordered.get(start);
                                                                                      ret.left = null;
                                                                                                  ret.right = null;
                                                                                                              return ret;
                                                                                                                      } else {
                                                                                                                                  int mid = start + (end - start) / 2;
                                                                                                                                              TreeNode ret = ordered.get(mid);
                                                                                                                                                          ret.left = bst(start, mid - 1);
                                                                                                                                                                      ret.right = bst(mid + 1, end);
                                                                                                                                                                                  return ret;
                                                                                                                                                                                          }
                                                                                                                                                                                              }
                                                                                                                                                                                                  private void inOrder(TreeNode node) {
                                                                                                                                                                                                          if (node == null)    return;
                                                                                                                                                                                                                  inOrder(node.left);
                                                                                                                                                                                                                          ordered.add(node);
                                                                                                                                                                                                                                  inOrder(node.right);
                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                      }