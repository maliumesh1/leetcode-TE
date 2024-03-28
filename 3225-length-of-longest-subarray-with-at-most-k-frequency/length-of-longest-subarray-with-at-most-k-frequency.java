class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int m1=Integer.MIN_VALUE;
        int m2=Integer.MAX_VALUE;
        
        for(int num:nums){
            m1=Math.max(m1,num);
            m2=Math.min(m2,num);
        }
        int max=0;
        int[] f=new int[m1-m2+1];
        
        int l=0;
        int r=0;
        
        while(r<nums.length){
            f[nums[r]-m2]++;
            
            while(count(f,nums[r]-m2)>k){
                f[nums[l]-m2]--;
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;    
    }
    public int count(int[] f,int n){
        return f[n];
    }
}