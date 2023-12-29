import java.util.Arrays;

class Solution {
    public int minDifficulty(int[] jobDifficulty, int days) {
        int length = jobDifficulty.length;
        if (days > length) return -1;

        int[][] minDifficulties = new int[days][length];
        for (int i = 1; i < days; ++i) {
            Arrays.fill(minDifficulties[i], Integer.MAX_VALUE);
        }

        int maxDiff = 0;
        int i = 0;
        while (i <= length - days) {
            maxDiff = Math.max(maxDiff, jobDifficulty[i]);
            minDifficulties[0][i] = maxDiff;
            ++i;
        }

        int currentDay = 1;
        while (currentDay < days) {
            int to = currentDay;
            while (to <= length - days + currentDay) {
                int currentJobDifficulty = jobDifficulty[to];
                int result = Integer.MAX_VALUE;
                int j = to - 1;
                while (j >= currentDay - 1) {
                    result = Math.min(result, minDifficulties[currentDay - 1][j] + currentJobDifficulty);
                    currentJobDifficulty = Math.max(currentJobDifficulty, jobDifficulty[j]);
                    --j;
                }
                minDifficulties[currentDay][to] = result;
                ++to;
            }
            ++currentDay;
        }

        return minDifficulties[days - 1][length - 1];
    }
}

