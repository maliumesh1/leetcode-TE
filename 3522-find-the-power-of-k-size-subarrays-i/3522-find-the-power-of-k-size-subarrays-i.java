class Solution {

    public int[] resultsArray(int[] nums, int k) {
        final int n = nums.length;
        int last = nums[0] - 1;
        int consecutive = 0;
        final int[] out = new int[1 + n - k];
        for (int i = 0; i < n; ++i) {
            final int num = nums[i];
            if (num == (last + 1)) {
                consecutive++;
            } else {
                consecutive = 1;
            }
            last = num;
            final int o = 1 + i - k;
            if (o >= 0) {
                out[o] = (consecutive >= k ? last : -1);
            }
        }
        return out;
    }

}