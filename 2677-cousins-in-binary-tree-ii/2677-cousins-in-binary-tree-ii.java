class Solution {
    // The nodes[] array contains the list of nodes for a breadth
    // first search (BFS) of a level of the tree, while building
    // the list of nodes for the BFS for the next level. These
    // two lists are stored in the nodes[] array at the same time.
    // One list, the "left" list, is built from the start of
    // nodes[] going upward in the array. The other list, the
    // "right" list, is built from the end of nodes[] going
    // downward. Because the tree has a maximum of 100_000 (10^5)
    // nodes, we will need an array of size 100_000/2 == 50_000
    // to simultaneously hold both lists in the same array.
    // But for this leetcode problem's test cases in April 2023,
    // an array length of 9000 is long enough. By making this
    // array a static, the array will only be allocated once for
    // all the leetcode problem's test cases, instead of allocating
    // the array again for each test case, which would require
    // slower runtime.
    static final TreeNode[] nodes = new TreeNode[50_000];

    public TreeNode replaceValueInTree(TreeNode root) {
        nodes[0] = root;
        int sumL = root.val;
        int sumR = 0;
        final int startL = 0;
        final int startR = nodes.length - 1;
        int lastL = startL + 1;
        int lastR = startR;
        TreeNode node = null;

        // Loop through the levels of the tree in a breadth first
        // search (BFS) of the tree nodes. Each time through this
        // loop processes the next two levels of the tree. First
        // processing the list of nodes on the left side of nodes[]
        // while building the list of the next level's nodes on
        // the right side of nodes[]. Then secondly, processing
        // the list of nodes on the right side of nodes[] while
        // building the list of the next level's nodes on the left
        // side of nodes[].
        while (lastL != 0) {
            // Process the list of nodes on the left side of nodes[]
            // while building the list of the next level's nodes on
            // the right side of nodes[].
            sumR = 0;
            while (lastL > 0) {
                node = nodes[--lastL];
                node.val = sumL - node.val;
                if (node.left != null) {
                    if (node.right != null) { // If two children.
                        sumR += node.left.val = node.right.val = node.left.val + node.right.val;
                        nodes[lastR--] = node.left;
                        nodes[lastR--] = node.right;
                    } else { // If left child only.
                        sumR += node.left.val;
                        nodes[lastR--] = node.left;
                    }
                } else if (node.right != null) { // If right child only.
                    sumR += node.right.val;
                    nodes[lastR--] = node.right;
                }
            }
            if (lastR == startR)
                break; // If no more levels.
            // Process the list of nodes on the right side of
            // nodes[] while building the list of the next level's
            // nodes on the left side of nodes[].
            sumL = 0;
            while (lastR < startR) {
                node = nodes[++lastR];
                node.val = sumR - node.val;
                if (node.left != null) {
                    if (node.right != null) { // If two children.
                        sumL += node.left.val = node.right.val = node.left.val + node.right.val;
                        nodes[lastL++] = node.left;
                        nodes[lastL++] = node.right;
                    } else { // If left child only.
                        sumL += node.left.val;
                        nodes[lastL++] = node.left;
                    }
                } else if (node.right != null) { // If right child only.
                    sumL += node.right.val;
                    nodes[lastL++] = node.right;
                }
            }
        }
        return root;
    }

}