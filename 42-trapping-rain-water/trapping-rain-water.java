class Solution 
{
    public int trap(int[] height) 
    {
        //calculating left max boundry
        int n = height.length;
        int lmax[]= new int [n];
        lmax[0] = height[0];
        for(int i=1 ; i<n ; i++)
        {
            lmax[i] = Math.max(height[i] , lmax[i-1]);
        }

        //calculating right max boundry
        int rmax[] = new int [n];
        rmax[n-1] = height[n-1];
        for(int i=n-2 ; i>=0 ; i--)
        {
            rmax[i] = Math.max(height[i],rmax[i+1]);
        }
        int t = 0;

        for (int i=0 ; i<n ; i++)
        {
           int wl = Math.min(lmax[i],rmax[i]);
           t += wl - height[i];
        }
        return t ;
    }
}