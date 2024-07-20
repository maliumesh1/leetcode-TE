class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int r = rowSum.length, c = colSum.length;

        int matrix[][] = new int[r][c];
        for (int i = 0, j = 0; (i < r) && (j < c); i += (rowSum[i] == 0) ? 1 : 0, j += (colSum[j] == 0) ? 1 : 0) {
            int val = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = val;
            rowSum[i] -= val;
            colSum[j] -= val;
        }

        return matrix;

    }
}