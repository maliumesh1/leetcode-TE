class Solution {
    public Integer[][][] dp;
    public int mod = 1_000_000_000+7;
    public int m, n;
    public int findPaths(int m, int n, int maxMove, int x, int y) {
        dp = new Integer[m][n][maxMove+1];
        this.m=m;
        this.n=n;
        return helper(maxMove, x, y);
    }

    private int helper(int maxMove, int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n)return 1;
        if(maxMove <= 0)return 0;
        if(dp[x][y][maxMove] != null){
            return dp[x][y][maxMove];
        }
        int res=0;
        
        res=(res+helper(maxMove-1, x+1, y))%mod;
        res=(res+helper(maxMove-1, x, y-1))%mod;
        res=(res+helper(maxMove-1, x-1, y))%mod;
        res=(res+helper(maxMove-1, x, y+1))%mod;

        dp[x][y][maxMove]=res;

        return res;

    }
}