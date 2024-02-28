class Solution {
    int ans=0;
    int height=0;
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return -1;
        findBottomLeftValue( root , 1);
        return ans;
    }
    public void findBottomLeftValue(TreeNode root , int h){
        if(root==null)return;
       if(root.left==null && root.right==null){
           if(h>height){
               height=h;
               ans=root.val;
           }
       }
       findBottomLeftValue(root.left,h+1);
       findBottomLeftValue(root.right,h+1);
    }
}