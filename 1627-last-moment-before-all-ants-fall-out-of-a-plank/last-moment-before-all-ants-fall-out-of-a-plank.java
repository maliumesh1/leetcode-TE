class Solution 
{
    //problem of the day 4 Nov 2023

    public int getLastMoment(int n, int[] left, int[] right) 
    {
        int ans = 0;
        for (int x : left) 
        {
            ans = Math.max(ans, x);
        }

        for (int x : right) 
        {
            ans = Math.max(ans, n - x);
        }
        return ans;
    }
}