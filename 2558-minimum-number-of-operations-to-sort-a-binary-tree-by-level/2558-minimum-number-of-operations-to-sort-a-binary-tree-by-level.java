class Solution {
    static final int SHIFT = 20;
    static final int MASK = 0xFFFFF;

    public int minimumOperations(TreeNode root) {
        LinkedList<TreeNode> bfsList = new LinkedList();
        bfsList.addLast(root);
        int swapCount = 0;

        while (!bfsList.isEmpty()) {
            int nodeCount = bfsList.size();
            long[] sortedNodes = new long[nodeCount];
            for (int i = 0; i < nodeCount; i++) {
                TreeNode node = bfsList.pollFirst();
                sortedNodes[i] = ((long) node.val << SHIFT) + i;
                if (node.left != null)
                    bfsList.addLast(node.left);
                if (node.right != null)
                    bfsList.addLast(node.right);
            }

            Arrays.sort(sortedNodes);
            for (int i = 0; i < nodeCount; i++) {
                int origIdx = (int) (sortedNodes[i] & MASK);
                if (origIdx != i) {
                    long temp = sortedNodes[i];
                    sortedNodes[i--] = sortedNodes[origIdx];
                    sortedNodes[origIdx] = temp;
                    swapCount++;
                }
            }
        }

        return swapCount;
    }

}