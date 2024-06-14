class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int m = 0;
        for(int i: nums){
            m = Math.max(i, m);
        }
        int[] bucket = new int[++m];
        for(int i: nums){
            bucket[i]++;
        }
        int res = 0;
        for(int i = 0; i < m-1; i++){
            if(bucket[i] <= 1) continue;
            res += bucket[i] - 1;
            bucket[i+1] += bucket[i] - 1;
        }
        if(bucket[m -1] <= 1) return res;
        bucket[m-1]--;
        return res + ((bucket[m-1] + 1)*bucket[m-1])/2;
    }
}