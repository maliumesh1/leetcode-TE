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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        stk1.push(root);

        while (!stk1.isEmpty()) {
            TreeNode node = stk1.pop();
            stk2.push(node);

            if (node.left != null) {
                stk1.push(node.left);
            }
            if (node.right != null) {
                stk1.push(node.right);
            }
        }

        while (!stk2.isEmpty()) {
            res.add(stk2.pop().val);
        }

        return res;
    }
}