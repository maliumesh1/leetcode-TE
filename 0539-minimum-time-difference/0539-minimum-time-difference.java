class Solution {
    public int findMinDifference(List<String> timePoints) {

        BitSet bs = new BitSet();

        // parse time to minutes
        for (int i = 0, n = timePoints.size(); i < n; i++) {
            int minutes = toMinutes(timePoints.get(i));
            if (bs.get(minutes)) {// duplicate time entry
                return 0;
            } else {
                bs.set(minutes);
            }
        }

        int diff = Integer.MAX_VALUE;
        int first = -1, curr = -1;

        for (int ind = bs.nextSetBit(0); ind >= 0; ind = bs.nextSetBit(ind + 1)) {
            if (curr < 0) {
                curr = first = ind;
                continue;
            }

            diff = Math.min(diff, ind - curr);
            curr = ind;
        }

        diff = Math.min(diff, 24 * 60 - curr + first); // check from 23:... to 00:...

        return diff;
    }

    private static int toMinutes(String time) {
        return (int) (time.charAt(0) - '0') * 10 * 60 +
                (int) (time.charAt(1) - '0') * 60 +
                (int) (time.charAt(3) - '0') * 10 +
                (int) (time.charAt(4) - '0');

    }
}