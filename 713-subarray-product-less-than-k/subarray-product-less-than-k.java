class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;

        int prod = 1;
        int result = 0;

        int left = 0;
        int right = 0;

        while(right < nums.length){
            prod *= nums[right];

            while(prod >= k){
                prod /= nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}