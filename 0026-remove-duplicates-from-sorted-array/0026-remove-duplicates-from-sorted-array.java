class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int reNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != reNum) {
                reNum = nums[i];
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}