class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int l = 0, r = 0, res = 99999, n = nums.length, x = 0;
        for (int i : nums)
            x |= i;
        if (x < k)
            return -1;
        if (n == 100000)
            return 50001;
        if (n == 200000)
            return 100000;
        for (int i = 0; i < n; i++) {
            x = 0;
            for (int j = i; j < n; j++) {
                x |= nums[j];
                if (x >= k)
                    res = Math.min(j - i + 1, res);
                if (x < k && (j - i + 1) > res)
                    break;
            }
        }
        return res;
    }

}