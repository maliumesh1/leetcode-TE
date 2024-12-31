class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return memoizedSol(days.length, days, costs, 0, dp);
    }

    public int memoizedSol(int n, int[] days, int[] cost, int index, int[] dp) {
        if (index >= n) {
            // days exceeded
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // 1 - day pass
        int option1 = cost[0] + memoizedSol(n, days, cost, index + 1, dp);

        // 7 day pass
        int i;
        for (i = index; i < n && days[i] < days[index] + 7; i++) {
        }

        int option2 = cost[1] + memoizedSol(n, days, cost, i, dp);

        // 30 day pass
        for (i = index; i < n && days[i] < days[index] + 30; i++) {
        }

        int option3 = cost[2] + memoizedSol(n, days, cost, i, dp);

        dp[index] = Math.min(Math.min(option2, option1), option3);
        return dp[index];
    }

}