class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];   // consider 1st element to be greatest sub-array.

        for(int i = 1; i < nums.length; i++){

            // If the cur sub-array sum is negative then reset is to 0.
            if(curSum < 0)
            {
                curSum = 0;
            }

            // Iterate over the array and calculate sub-array sum.
            curSum += nums[i];

            // maxSum will be greater of curSum and maxSum.
            maxSum = Math.max(maxSum, curSum);

        }

        // finally, return the maxSum.
        return maxSum; 

    }
}