class Solution {
    // FlipEquiv Function
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // if, both the trees are same than, return true
        if (root1 == root2)
            return true;
        // if, root1 or root2 is null
        // or root1 value is not equal to root2 value than, return false
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;

        // return, (root1 left is equal to root2 left) && (root1 right is equal to root2
        // right) than, return true OR
        // (root1 left is equal to root2) right && (root1 right is equal to root2 left)
        // than, return true
        // both the case are not true than, return false
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}