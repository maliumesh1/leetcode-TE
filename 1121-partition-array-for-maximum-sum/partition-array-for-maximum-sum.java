class Solution {
    Integer[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        memo=new Integer[arr.length];
        return sol(arr,k,0);
    }
    public int sol(int[] arr,int k,int idx){
        if(idx==arr.length) return 0;
        if(memo[idx]!=null) return memo[idx];
        int ans=0,max=0;
        for(int i=idx;i<idx+k && i<arr.length;i++){
            max=Math.max(max,arr[i]);
            ans=Math.max(ans,sol(arr,k,i+1)+(i-idx+1)*max);
        }
        return memo[idx]=ans;
    }
}