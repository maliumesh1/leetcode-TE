class Solution {
    static final int MODULO = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        int[] prefixPrefixSums = new int[n + 1];
        prefixPrefixSums[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixPrefixSums[i + 1] = prefixPrefixSums[i] + prefixSums[i + 1];
        }
        return (getSum(prefixSums, prefixPrefixSums, n, right) - getSum(prefixSums, prefixPrefixSums, n, left - 1))
                % MODULO;
    }

    public int getSum(int[] prefixSums, int[] prefixPrefixSums, int n, int k) {
        int num = getKth(prefixSums, n, k);
        int sum = 0;
        int count = 0;
        for (int i = 0, j = 1; i < n; i++) {
            while (j <= n && prefixSums[j] - prefixSums[i] < num) {
                j++;
            }
            j--;
            sum = (sum + prefixPrefixSums[j] - prefixPrefixSums[i] - prefixSums[i] * (j - i)) % MODULO;
            count += j - i;
        }
        sum = (sum + num * (k - count)) % MODULO;
        return sum;
    }

    public int getKth(int presum[], int n, int k) {
        int lo = 1;
        int hi = presum[n];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = count(presum, n, mid);
            if (cnt < k)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return lo;
    }

    public int count(int presum[], int n, int x) {
        int i = 0;
        int j = 1;
        int cnt = 0;

        while (i < n && j <= n) {
            if (presum[j] - presum[i] <= x) {
                cnt += j - i;
                j++;
            } else {
                i++;
            }
        }

        return cnt;
    }

}