final class Solution {
    public final long countFairPairs(int[] nums, final int lower, final int upper) {
        Arrays.sort(nums);
        return Solution.countLessOrEqual(nums, upper) - Solution.countLessOrEqual(nums, lower - 1);
    }

    private static final long countLessOrEqual(final int[] nums, final int target) {
        long count = 0;
        for (int iLeft = 0, iRight = nums.length - 1; iLeft < iRight; count += iRight - iLeft++)
            while (iLeft < iRight && nums[iLeft] + nums[iRight] > target)
                --iRight;
        return count;
    }

}