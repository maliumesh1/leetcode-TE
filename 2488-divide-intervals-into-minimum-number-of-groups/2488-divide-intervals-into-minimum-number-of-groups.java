class Solution {

    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    int[] counts;

    public int minGroups(int[][] intervals) {
        // first we can sort the intervals based on their arrival time
        // next we process each interval and we check if they intersect -> these
        // intervals intersect if the arrival time <= endtime of the previous interval
        // if they intersect, then I am sure they cannot be in the group as same as the
        // other
        // let us consider each arrival time as +1, representing that it is inserted at
        // that point of
        // time
        // and each departure time as -1, representing that an interval was removed, as
        // it has ended
        // now the maximum number of that we obtain, using this technique will represent
        // maximum subsequent additions, and thereby represent the maximum number of
        // groups that I need to make

        for (int[] interval : intervals) {
            minValue = Math.min(minValue, interval[0]);
            maxValue = Math.max(maxValue, interval[1] + 1);
        }

        counts = new int[maxValue - minValue + 1];

        for (int[] interval : intervals) {
            int ar = interval[0];
            int dep = interval[1];

            counts[ar - minValue]++;
            counts[dep + 1 - minValue]--;
        }

        int cur = 0;
        int ans = 0;

        for (int el : counts) {
            cur += el;
            ans = Math.max(cur, ans);
        }

        return ans;
    }

}