class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, res = 0;

        for (int l = 0; l < n; ++l) {
            int[] sums = new int[105];
            for (int r = l; r < n; ++r) {
                for (int i = 0; i < m; ++i) {
                    sums[i] += matrix[i][r];
                }
                for (int i = 0; i < m; ++i) {
                    int sum = 0;
                    for (int j = i; j < m; ++j) {
                        sum += sums[j];
                        if (sum == target) {
                            ++res;
                        }
                    }
                }
            }
        }
        return res;
    }
}