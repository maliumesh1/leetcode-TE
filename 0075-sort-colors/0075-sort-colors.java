class Solution {
    public void sortColors(int[] arr) {
        int low = 0 , mid = 0 , high = arr.length -1 ;
        while(mid <= high) {
            if(arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            }else if (arr[mid]==1){
                mid++;
            }else {
                swap(arr,mid,high);
                high--;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}