class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            int x = a[0] - b[0];
            if (x != 0)
                return x;
            return a[2] - b[2];
        });
        int[] startAt = new int[events.length];
        int[] maxFrom = new int[events.length + 1];
        for (int i = events.length - 1; i >= 0; i--) {
            startAt[i] = events[i][0];
            maxFrom[i] = Math.max(maxFrom[i + 1], events[i][2]);
        }
        int maxValue = 0;
        for (int[] e : events) {
            int idx = Arrays.binarySearch(startAt, e[1] + 1);
            if (idx < 0) {
                idx = -idx - 1;
            }
            maxValue = Math.max(maxValue, e[2] + maxFrom[idx]);
        }
        return maxValue;
    }

}