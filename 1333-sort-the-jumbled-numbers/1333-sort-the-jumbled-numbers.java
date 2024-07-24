class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return nums;

        int maxNum = 1;
        for (int num : nums)
            if (num > maxNum)
                maxNum = num;

        int[] result = new int[n];
        int[] digit = new int[n];
        for (int pow10 = 1; pow10 <= maxNum; pow10 *= 10) {
            final int testPow10 = (pow10 == 1) ? 0 : pow10;
            int[] freq = new int[10];
            for (int i = n - 1; i >= 0; i--)
                freq[digit[i] = ((nums[i] < testPow10) ? 0 : mapping[(nums[i] / pow10) % 10])]++;

            for (int i = 1; i < 10; i++)
                freq[i] += freq[i - 1];

            for (int i = n - 1; i >= 0; i--)
                result[--freq[digit[i]]] = nums[i];

            int[] tmpResult = result;
            result = nums;
            nums = tmpResult;
        }
        return nums;
    }

}