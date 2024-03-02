class Solution {
    public int[] sortedSquares(int[] nums) {
//we are going to follow two pointer approach

        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int ans[] = new int[n];
        int x = n - 1;

        while (s <= e) {
            if (Math.abs(nums[s]) > Math.abs(nums[e])) {
                ans[x] = Math.abs(nums[s] * nums[s]);
                x--;
                s++;
            } else {
                ans[x] = Math.abs(nums[e] * nums[e]);
                x--;
                e--;
            }
        }
        return ans;

        
    }
}