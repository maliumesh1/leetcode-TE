class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Bucket for 0 <= arr element <= 1000
        int[] bucket = new int[1001];
        
        int[] result = new int[arr1.length];
        int index = 0;
        
        // Fill bucket
        for(int i : arr1) {
            bucket[i]++;
        }
        
        // First store result in order of arr2
        for(int i : arr2) {
            while(bucket[i]-- > 0) {
                result[index++] = i;
            }
        }
        
        // Fill remaining element
        for(int i = 0; i < 1001; i++){
            if(bucket[i] > 0) {
                while(bucket[i]-- > 0) {
                    result[index++] = i;
                }
            }
        }
        return result;
    }
}