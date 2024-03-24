// Takes 1ms
class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for(int i:nums){
            if(arr[i]) return i;
            arr[i] = true;
        }
        return -1;
    }
}