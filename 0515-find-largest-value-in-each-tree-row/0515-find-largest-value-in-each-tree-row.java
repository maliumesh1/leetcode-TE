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
    List<Integer> lis = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        bfs(root, 0);
        return lis;
    }

    public void bfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (lis.size() == level)
            lis.add(root.val);
        else {
            lis.set(level, Math.max(lis.get(level), root.val));
        }
        bfs(root.left, level + 1);
        bfs(root.right, level + 1);
    }
}