class Solution {
    public final int countSquares(int[][] matrix) {
        int nbSquares = 0;
        final int nbRows = matrix.length, nbColumns = matrix[0].length;
        for (int i = 0; i < nbRows; ++i) {
            int[] row = matrix[i];
            for (int j = 0; j < nbColumns; nbSquares += row[j++])
                if (row[j] > 0 && i > 0 && j > 0)
                    row[j] += Math.min(row[j - 1], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]));
        }
        return nbSquares;
    }
}
