class Solution {
    public int longestSquareStreak(int[] nums) {
        // Use boolean array instead of HashSet - more memory efficient
        // Since nums[i] <= 10^5, we only need array of this size
        boolean[] present = new boolean[100001];

        // Mark all present numbers - O(n)
        for (int num : nums) {
            present[num] = true;
        }

        int maxStreak = -1;

        // Start from smaller numbers since their squares will be larger
        // This ensures we don't process same sequence multiple times
        for (int num = 2; num <= 317; num++) { // sqrt(100000) ≈ 316.22...
            if (!present[num])
                continue;

            int currentStreak = 1;
            long square = (long) num * num;

            // Keep checking squares while they're within bounds
            while (square <= 100000 && present[(int) square]) {
                currentStreak++;
                square = square * square;
            }

            if (currentStreak >= 2) {
                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }

        return maxStreak;
    }

}