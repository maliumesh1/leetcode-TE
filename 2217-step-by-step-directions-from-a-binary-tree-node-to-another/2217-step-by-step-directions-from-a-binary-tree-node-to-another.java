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
    public static char arr[] = new char[100001];
    public static int ptrs, ptre;
    public static int startValue, destValue;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        Solution.startValue = startValue;
        Solution.destValue = destValue;
        ptrs = 0;
        ptre = 100000;
        find(root);
        if (ptrs > 0)
            return new String(arr, 0, ptrs);
        return new String(arr, ptre + 1, 100000 - ptre);
    }

    public static int find(TreeNode root) {
        if (root == null)
            return 0;
        if (root.val == destValue) {
            if (targetStart(root.left) || targetStart(root.right))
                return -1;
            return destValue;
        }
        if (root.val == startValue) {
            if (targetDest(root.left, 'L') || targetDest(root.right, 'R'))
                return -1;
            return startValue;
        }
        int lef = find(root.left);
        if (lef != 0) {
            if (lef != -1) {
                if (lef == destValue) {
                    arr[ptre--] = 'L';
                    if (targetStart(root.right))
                        return -1;
                } else {
                    arr[ptrs++] = 'U';
                    if (targetDest(root.right, 'R'))
                        return -1;
                }
                return lef;
            }
            return -1;
        }
        lef = find(root.right);
        if (lef != 0) {
            if (lef == -1)
                return -1;
            if (lef == destValue)
                arr[ptre--] = 'R';
            else
                arr[ptrs++] = 'U';
            return lef;
        }
        return 0;
    }

    public static boolean targetStart(TreeNode root) {
        if (root == null)
            return false;
        arr[ptre--] = 'U';
        if (root.val == startValue)
            return true;
        if (targetStart(root.left))
            return true;
        if (targetStart(root.right))
            return true;
        ptre++;
        return false;
    }

    public static boolean targetDest(TreeNode root, char c)
     {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              if (root == null)
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      return false;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              arr[ptrs++] = c;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      if (root.val == destValue)
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              return true;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      if (targetDest(root.left, 'L'))
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              return true;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      if (targetDest(root.right, 'R'))
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              return true;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ptrs--;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              return false;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  }
}