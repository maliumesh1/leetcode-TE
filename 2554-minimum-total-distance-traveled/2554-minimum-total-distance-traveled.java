final class Solution {
    private static final long MAX_TOTAL_DISTANCE = 200000000000L;

    public final long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        Collections.sort(robots);
        Arrays.sort(factories, (a, b) -> Integer.compare(a[0], b[0]));
        final int nbRobots = robots.size();
        long[] dp = new long[nbRobots + 1];
        Arrays.fill(dp, MAX_TOTAL_DISTANCE);
        dp[0] = 0;
        for (final int[] factory : factories) {
            final int position = factory[0];
            for (int limit = factory[1]; limit != 0; --limit)
                for (int i = nbRobots; i > 0; --i)
                    dp[i] = Math.min(dp[i], Math.abs(robots.get(i - 1) - position) + dp[i - 1]);
        }
        return dp[nbRobots];
    }

}