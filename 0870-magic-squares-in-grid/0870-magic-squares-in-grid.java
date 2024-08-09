class Solution {
    public boolean isMagic(int[][] grid, int row, int col) {
        boolean[] present = new boolean[9];
        int[] diagonal = new int[2];
        int[] rowsum = new int[3];
        int[] colsum = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[row + i][col + j] < 1 || grid[row + i][col + j] > 9) {
                    return false;
                }
                if (present[grid[row + i][col + j] - 1]) {
                    return false;
                }
                present[grid[row + i][col + j] - 1] = true;
                rowsum[i] += grid[row + i][col + j];
                colsum[j] += grid[row + i][col + j];
            }
        }
        diagonal[0] = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        diagonal[1] = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (rowsum[0] == rowsum[1] && rowsum[1] == rowsum[2]) {
            if (colsum[0] == colsum[1] && colsum[1] == colsum[2]) {
                if (diagonal[0] == diagonal[1]) {
                    if (rowsum[0] == colsum[0] && diagonal[0] == rowsum[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (isMagic(grid, i, j)) {
                    res += 1;
                }
            }
        }
        return res;
    }

}