class Solution 
{
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) 
    {
        ArrayList<Boolean> res = new ArrayList<>();;
        for(int i=0;i<l.length;i++)
           {
                res.add(isArithmetic(nums,l[i],r[i]));
           }
        return res;
    }
    
    private boolean isArithmetic(int[] nums, int start, int end)
    {
        int[] a = new int[end-start+1];
        int k=0;
        for(int i=start;i<=end;i++)
        {
            a[k++]=nums[i];
        }
        Arrays.sort(a);
        int diff=a[1]-a[0];
        for(int i=1;i<a.length-1;i++)
        {
            if(a[i]+diff!=a[i+1])
                return false;
        }
        return true;
    }
}