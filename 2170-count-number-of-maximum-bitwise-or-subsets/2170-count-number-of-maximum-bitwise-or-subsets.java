class Solution {
    static int[] tail = new int[16];
    int[] nums;
    int max;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max |= nums[i];
        }
        int v = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            v |= nums[i];
            tail[i] = v;
        }

        return recurse(0, 0);
    }

    int recurse(int i, int partial) {
        if (partial == max) {
            return 1 << (nums.length - i);
        }
        if (i == nums.length || ((partial | tail[i]) != max)) {
            return 0;
        }
        return recurse(i + 1, partial | nums[i])
                + recurse(i + 1, partial);
    }

}