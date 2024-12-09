class Solution {
    // 1ms, 100%
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] pc = new int[n];
        pc[0] = 0;

        for (int i = 1; i < n; i++) {
            pc[i] = pc[i - 1] + 1 - ((nums[i] ^ nums[i - 1]) & 1);
        }

        int m = queries.length;
        boolean a[] = new boolean[m];
        for (int i = 0; i < m; i++) {
            a[i] = (pc[queries[i][0]] == pc[queries[i][1]]);
        }

        return a;
    }

}