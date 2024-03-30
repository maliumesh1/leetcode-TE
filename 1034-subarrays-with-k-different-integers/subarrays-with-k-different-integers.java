class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int count = 0;
        int result = 0;
        int[] ans = new int[n + 1];

        for (int right = 0; right < n; right++) {
            if (++ans[nums[right]] == 1) {
                count++;
            }

            if (count == k) {
                int nextIndex = right + 1;
                while (nextIndex < n && ans[nums[nextIndex]] > 0) {
                    nextIndex++;
                }
                while (count == k) {
                    result += nextIndex - right;
                    if (--ans[nums[left++]] == 0) {
                        count--;
                    }
                }
            }
        }
        return result;
    }
}