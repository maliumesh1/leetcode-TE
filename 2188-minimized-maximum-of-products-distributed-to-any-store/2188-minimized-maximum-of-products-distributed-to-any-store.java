class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int sum = 0, max = 100000, min = 1;

        while (min < max) {
            int m = min + (max - min) / 2;
            if (canDistribute(m, n, quantities))
                max = m;
            else
                min = m + 1;
        }

        return min;
    }

    private boolean canDistribute(int k, int n, int[] quantities) {

        for (int num : quantities) {
            n -= (num + k - 1) / k;
            if (n < 0)
                return false;
        }

        return true;
    }

}