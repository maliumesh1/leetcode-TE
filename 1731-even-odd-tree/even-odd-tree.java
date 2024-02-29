/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    /*
        conditions to satisfy
            -even level -> all nodes are odd, and increasing
            -odd level -> all nodes are even, and decreasing
    */
    public boolean isEvenOddTree(TreeNode root) {
        
        Queue<TreeNode> q = new ArrayDeque<>();//Faster than Linked List
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();

            
            //to keep track if the nodes in the level are increasing/decreasing
            TreeNode prevNode = null; //reset prev for each level
            

            //loop for each level(queue is populated by prev parent nodes)
            for (int i = 0; i < qSize; i++) {
                TreeNode currentNode = q.poll();
                if (level % 2 == 0) {
                // even level
                    //check all false conditions and reject instantly
                    if (currentNode.val % 2 == 0) return false;//reject if EVEN

                    //compare with prev to ensure it is INCREASING
                    //reject if DECREASING
                    if (prevNode != null && prevNode.val >= currentNode.val) {
                        return false;
                    }
                } else {
                // odd level
                    //check all false conditions and reject instantly
                    if (currentNode.val % 2 > 0) return false;//reject if ODD

                    //compare with prev to ensure it is DECREASING
                    //reject if INCREASING
                    if (prevNode != null && prevNode.val <= currentNode.val) {
                        return false;
                    }
                }

                //assign current node to prev node
                //to check next nodes in the level
                prevNode = currentNode;

                //add next level nodes to be checked in next for
                if (currentNode.left != null) q.offer(currentNode.left);
                if (currentNode.right != null) q.offer(currentNode.right);
            }
            level++;
        }

        return true;
    }
}