class Solution {
    public int missingNumber(int[] arr) {
        int sum=0;
        int max=(arr.length*(arr.length+1))/2;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return max-sum;
    }
}