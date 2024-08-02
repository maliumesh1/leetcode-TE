class Solution {
    public int minSwaps(int[] nums) {
        int window = 0;

        for (int n : nums)
            window += n;

        int swaps = window;
        int l = 0;
        int ones = 0;
        int len = nums.length;

        for (int r = 0; r < len + window; r++) {
            ones += nums[r % len];

            if (r >= window)
                ones -= nums[l++];

            swaps = Math.min(swaps, window - ones);
        }

        return swaps;
    }

}