class Solution 
{
    public int[] getSumAbsoluteDifferences(int[] nums) 
    {
        int len = nums.length;
        int[] sum = new int[len], arr = new int[len];
        sum[0]=nums[0];
        for(int i=1;i<len;i++)
         {
           sum[i]=sum[i-1]+nums[i];
          }

         int total = sum[len-1];
         arr[0]=total-len*nums[0];
         for(int i=1;i<len;i++)
            {
            arr[i] = total - 2*sum[i-1] + (i)*nums[i] - (len-i)*nums[i]; 
             }        
         return arr;
        
    }
}