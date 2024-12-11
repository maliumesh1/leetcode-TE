class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int maxValue = 0;

        // Step 1: Find the maximum value in the array
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }

        // Step 2: Create an array to track ranges
        int[] range = new int[maxValue + 10];

        // Step 3: Mark ranges for each number in the array
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, nums[i] - k);
            int right = Math.min(maxValue, nums[i] + k) + 1;
            range[left]++;
            range[right]--;
        }

        // Step 4: Calculate prefix sums and find the maximum value
        int result = range[0];
        for (int i = 1; i < range.length; i++) {
            range[i] += range[i - 1];
            if (range[i] > result) {
                result = range[i];
            }
        }

        // Step 5: Return the result
        return result;
    }

}