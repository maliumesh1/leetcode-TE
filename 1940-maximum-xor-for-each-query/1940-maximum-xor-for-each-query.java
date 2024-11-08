class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int len = nums.length;
        int orr[] = new int[len];
        int ans = nums[0];
        int mask = (1 << maximumBit) - 1;
        orr[len - 1] = ~ans & mask;

        for (int i = 1, j = len - 2; i < len; i++) {
            ans = ans ^ nums[i];
            orr[j] = ~ans & mask;
            j--;
        }

        return orr;
    }

}