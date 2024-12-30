class Solution {
    int mod = 1000000007;

    // 1. Recursion -> TLE
    // Time: O(high*2^high) & Space: O(high)
    public int countGoodStringsRec(int target, int low, int high, int zero, int one) {

        // Base Cases

        // String is having a length between low and high (inclusive)
        if (target == 0)
            return 1;

        // String is NOT having a length between low and high (inclusive)
        if (target < 0)
            return 0;

        // 2 Recursive Calls
        // 1st for, when we add zero no. of 0s
        // 2nd for, when we add one no. of 1s
        // Adding Counts from each Recursive Calls
        return (countGoodStringsRec(target - zero, low, high, zero, one) % mod
                + countGoodStringsRec(target - one, low, high, zero, one) % mod) % mod;
    }

    // 2. Recursion + Memoization (DP)
    // Time: O(high^2) & Space: O(high)
    public int countGoodStringsRecMemDP(int[] dp, int target, int low, int high, int zero, int one) {

        // Base Cases

        // String is having a length between low and high (inclusive)
        if (target == 0)
            return 1;

        // String is NOT having a length between low and high (inclusive)
        if (target < 0)
            return 0;

        if (dp[target] != -1)
            return dp[target];

        // 2 Recursive Calls
        // 1st for, when we add zero no. of 0s
        // 2nd for, when we add one no. of 1s
        // Adding Counts from each Recursive Calls and saving to the DP array
        return dp[target] = (countGoodStringsRecMemDP(dp, target - zero, low, high, zero, one) % mod
                + countGoodStringsRecMemDP(dp, target - one, low, high, zero, one) % mod) % mod;
    }

    public int countGoodStrings(int low, int high, int zero, int one) {

        int goodStrings = 0;

        // 1. Recursion -> TLE
        // Counting Good Strings for each length between low and high (inclusive)
        /*
         * for(int len = low; len <= high; len++) {
         * goodStrings = ( goodStrings % mod + countGoodStringsRec(len, low, high, zero,
         * one) % mod ) % mod;
         * }
         */

        // 2. Recursion + Memoization (DP)
        // Time: O(high^2) & Space: O(high)
        // Counting Good Strings for each length between low and high (inclusive)

        /*
         * int[] dp = new int[high+1];
         * Arrays.fill(dp, -1);
         * 
         * for(int len = low; len <= high; len++) {
         * goodStrings = ( goodStrings % mod + countGoodStringsRecMemDP(dp, len, low,
         * high, zero, one) % mod ) % mod;
         * }
         */

        // 3. Tabulation / Bottom-Up Approach (DP)
        // Time & Space: O(high)
        // 100 % Faster Solution with 7 ms of Runtime
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int len = 1; len <= high; len++) {
            dp[len] = ((len - zero >= 0 ? dp[len - zero] : 0) + (len - one >= 0 ? dp[len - one] : 0)) % mod;
            if (len >= low)
                goodStrings = (goodStrings + dp[len]) % mod;
        }

        return goodStrings;
    }
}