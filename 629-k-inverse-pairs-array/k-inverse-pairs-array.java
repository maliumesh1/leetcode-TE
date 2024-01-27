class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        int[][] dp = new int[k + 1][n];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j > 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                    if (i >= j + 1) {
                dp[i][j] = (dp[i][j] - dp[i - j - 1][j - 1] + MOD) % MOD;
                    }
                }
            }
        }
        return dp[k][n-1];
    }
}