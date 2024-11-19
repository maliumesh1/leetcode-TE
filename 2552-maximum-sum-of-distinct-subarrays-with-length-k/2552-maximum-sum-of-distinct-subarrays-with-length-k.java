final class Solution {
    private static final int MAX_VALUE = 100001;
    private int k, nbDistinct = 0;
    private long sum = 0, maxSum = 0;
    private int[] counter = new int[Solution.MAX_VALUE];

    public final long maximumSubarraySum(final int[] nums, final int k) {
        this.k = k;
        this.setFirstWindow(nums);
        final int nbElements = nums.length;
        for (int i = this.k; i < nbElements; this.slideWindow(nums[i - this.k], nums[i++]))
            if (this.nbDistinct == this.k)
                this.maxSum = Math.max(this.maxSum, this.sum);
        return this.nbDistinct == this.k ? Math.max(this.maxSum, this.sum) : this.maxSum;
    }

    private final void setFirstWindow(final int[] nums) {
        for (int i = 0; i < this.k; this.sum += nums[i++])
            if (++this.counter[nums[i]] == 1)
                ++this.nbDistinct;
    }

    private final void slideWindow(final int leftValue, final int rightValue) {
        if (++this.counter[rightValue] == 1)
            ++this.nbDistinct;
        if (--this.counter[leftValue] == 0)
            --this.nbDistinct;
        this.sum += rightValue - leftValue;
    }

}