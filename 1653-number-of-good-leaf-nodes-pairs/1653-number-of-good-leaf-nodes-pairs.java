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
    int dist;
    int res;
    int maxDist;

    public int countPairs(TreeNode root, int distance) {
        dist = distance;
        res = 0;
        maxDist = distance + 2;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root){
                                                                                      if(root == null) return null;
                                                                                              int[] left = dfs(root.left);
                                                                                                      int[] right = dfs(root.right);
                                                                                                              int[] current = new int[maxDist];
                                                                                                                      if(left == null && right == null){
                                                                                                                                  current[1] = 1;
                                                                                                                                              return current;
                                                                                                                                                      }
                                                                                                                                                              if(left == null){
                                                                                                                                                                          for(int i = 1; i < maxDist-1; i++){
                                                                                                                                                                                          current[i+1] = right[i];
                                                                                                                                                                                                      }
                                                                                                                                                                                                                  return current;
                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                  if(right == null){
                                                                                                                                                                                                                                              for(int i = 1; i < maxDist-1; i++){
                                                                                                                                                                                                                                                              current[i+1] = left[i];
                                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                                                      return current;
                                                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                                                      for(int i = 1; i < maxDist-1; i++){
                                                                                                                                                                                                                                                                                                                  current[i+1] = left[i] + right[i];
                                                                                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                                                                                                  for(int i = 1; i < maxDist; i++){
                                                                                                                                                                                                                                                                                                                                              for(int j = 1; j+i <= dist; j++){
                                                                                                                                                                                                                                                                                                                                                              res += left[i] * right[j];
                                                                                                                                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                                                                                                                                          return current;
                                                                                                                                                                                                                                                                                                                                                                                              }
}