class Solution {
    private boolean count(int[] bloomDay, int val, int k, int m) {
        int temp = 0, temp2 = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= val) {
                temp++;
                if (temp == k) {
                    temp = 0;
                    temp2++;
                    if (temp2 == m)
                        return true;
                }
            } else {
                if ((bloomDay.length - i) / k < m - temp2)
                    return false;
                temp = 0;
            }
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k < 0 || m * k > bloomDay.length) return -1;

        int max = bloomDay[0];

        for (int i = 1; i < bloomDay.length; i++)
            max = Math.max(max, bloomDay[i]);

        int st = 1, en = max, md;

        while (st <= en) {
            md = (st + en) / 2;
            if (count(bloomDay, md, k, m)) {
                en = md - 1;
            } else
                st = md + 1;
        }

        return st;
    }
}