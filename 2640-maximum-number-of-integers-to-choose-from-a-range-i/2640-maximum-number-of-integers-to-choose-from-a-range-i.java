class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean arr[] = new boolean[10002];
        for (int i = 0; i < banned.length; i++)
            arr[banned[i]] = true;

        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!arr[i]) {
                sum += i;
                if (sum > maxSum)
                    return count;
                count++;
            }
        }
        return count;
    }

}