class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0;
        int range_min = Integer.MAX_VALUE;
        int range_max = Integer.MIN_VALUE;

        long count = 0;
        long win_size;
        int right;
        for (right = 0; right < n; right++) {
            range_min = Math.min(range_min, nums[right]);
            range_max = Math.max(range_max, nums[right]);

            if (range_max - range_min > 2) {
                win_size = right - left;
                count += (win_size * (win_size + 1)) / 2;

                left = right;
                // expand current window to as left as possible
                range_min = nums[right];
                range_max = nums[right];
                while (Math.abs(nums[right] - nums[left - 1]) <= 2) {
                    left--;
                    range_min = Math.min(range_min, nums[left]);
                    range_max = Math.max(range_max, nums[left]);
                }
                // substract overcounted subarrays
                if (left < right) {
                    win_size = right - left;
                    count -= (win_size * (win_size + 1)) / 2;
                }
            }
        }
        // add subarrays from last window
        win_size = right - left;
        count += (win_size * (win_size + 1)) / 2;
        return count;
    }

}