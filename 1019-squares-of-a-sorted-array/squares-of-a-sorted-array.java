class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] copy = new int[nums.length];
        int l = 0,r = nums.length - 1;
        while (r>=l){
            // check largest; add to index; increment resp pointer

            // largest is pos
            if (Math.abs(nums[r]) > Math.abs(nums[l])){
                copy[r-l] = nums[r]*nums[r];
                r--;
            }
            // largest is neg; 
            else if (Math.abs(nums[l]) >= Math.abs(nums[r])){
                copy[r-l] = nums[l]*nums[l];
                l++;
            }
        }
        return copy;
    }
}