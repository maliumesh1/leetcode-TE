class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1)
            return true;

        int previous = (nums[0] & 1);
        for (int i = 1; i < nums.length; i++) {
            int current = (nums[i] & 1);
            if (previous == current)
                return false;

            previous = current;
        }
        return true;

    }
}