
class Solution {

    private int maximumStones(int[] suffixSum, int M, int currInd, int[][] dp) {
        if (currInd + 2 * M >= suffixSum.length) {
            return suffixSum[currInd];
        }

        if (dp[currInd][M] > 0)
            return dp[currInd][M];

        int res = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
            res = Math.min(res, maximumStones(suffixSum, Math.max(x, M), currInd + x, dp));
        }

        dp[currInd][M] = suffixSum[currInd] - res;
        return dp[currInd][M];
    }

    public int stoneGameII(int[] piles) {
        // SuffixSum Array
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return maximumStones(suffixSum, 1, 0, new int[n][n]);
    }
}
