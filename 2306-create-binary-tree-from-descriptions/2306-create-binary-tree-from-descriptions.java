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
    public TreeNode createBinaryTree(final int[][] descriptions) {
                          final TreeNode[] nodes = new TreeNode[100001];
                                  final boolean[] children = new boolean[100001];
                                  
                                          for (final int[] description : descriptions) {
                                                      if (nodes[description[0]] == null)
                                                                      nodes[description[0]] = new TreeNode(description[0]);
                                                                      
                                                                                  if (nodes[description[1]] == null)
                                                                                                  nodes[description[1]] = new TreeNode(description[1]);
                                                                                                  
                                                                                                              if (description[2] == 0)
                                                                                                                              nodes[description[0]].right = nodes[description[1]];
                                                                                                                                          else
                                                                                                                                                          nodes[description[0]].left = nodes[description[1]];
                                                                                                                                                          
                                                                                                                                                                      children[description[1]] = true;
                                                                                                                                                                              }
                                                                                                                                                                              
                                                                                                                                                                                      for (final int[] description : descriptions)
                                                                                                                                                                                                  if (!children[description[0]])
                                                                                                                                                                                                                  return nodes[description[0]];
                                                                                                                                                                                                                  
                                                                                                                                                                                                                          return null;
                                                                                                                                                                                                                              }
}