class Solution {
    static public int minimumMountainRemovals(int[] nums) {
        int n = nums.length, newLength = 0, idx = 0, max = 0;
        int[] arr = new int[n];
        int[] res1 = new int[n];
        int first = 1;
        while (first < n) {
            if (nums[first] <= nums[first - 1])
                first++;
            else
                break;
        }
        first--;
        int maxele = 0;
        for (int i = 0; i < n; i++) {
            newLength = LIS(arr, nums[i], newLength);
            res1[idx++] = newLength;
            if (maxele < nums[i])
                maxele = nums[i];
        }
        newLength = 0;
        int second = n - 2;
        while (second >= 0) {
            if (nums[second] <= nums[second + 1])
                second--;
            else
                break;
        }
        second++;
        for (int i = n - 1; i - 1 >= first; i--) {
            if (nums[i] != maxele) {
                newLength = LIS(arr, nums[i], newLength);
                if (i > 0 && i <= second)
                    if (max < newLength + res1[i - 1])
                        max = newLength + res1[i - 1];
            }
        }
        return n - max;
    }

    static int LIS(int[] arr, int x, int n) {
        int start = 0, end = n - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] >= x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        arr[start] = x;
        return n > start + 1 ? n : start + 1;
    }

}