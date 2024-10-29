class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] check = new boolean[rows][cols];
        int max = 0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            count = maxstep(i, 0, rows, cols, grid, check) - 1;
            if (max < count) {
                max = count;
            }
            if (max == cols - 1) {
                return max;
            }
        }
        return max;
    }

    public static int maxstep(int i, int j, int rows, int cols, int[][] grid, boolean[][] check) {
        int max = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        if (i == 0 && j < cols - 1) {
            if (check[i][j + 1] == false && grid[i][j] < grid[i][j + 1]) {
                check[i][j + 1] = true;
                count1 = maxstep(i, j + 1, rows, cols, grid, check);
            }
            if (check[i + 1][j + 1] == false && grid[i][j] < grid[i + 1][j + 1]) {
                check[i + 1][j + 1] = true;
                count2 = maxstep(i + 1, j + 1, rows, cols, grid, check);
            }
            max = Math.max(count1, count2);
        } else if (i == rows - 1 && j < cols - 1) {
            if (check[i - 1][j + 1] == false && grid[i][j] < grid[i - 1][j + 1]) {
                check[i - 1][j + 1] = true;
                count1 = maxstep(i - 1, j + 1, rows, cols, grid, check);

            }
            if (check[i][j + 1] == false && grid[i][j] < grid[i][j + 1]) {
                check[i][j + 1] = true;
                count2 = maxstep(i, j + 1, rows, cols, grid, check);
            }
            max = Math.max(count1, count2);

        } else if (j < cols - 1) {

            if (check[i - 1][j + 1] == false && grid[i][j] < grid[i - 1][j + 1]) {
                check[i - 1][j + 1] = true;
                count1 = maxstep(i - 1, j + 1, rows, cols, grid, check);

            }
            if (check[i][j + 1] == false && grid[i][j] < grid[i][j + 1]) {
                check[i][j + 1] = true;
                count2 = maxstep(i, j + 1, rows, cols, grid, check);
            }
            if (check[i + 1][j + 1] == false && grid[i][j] < grid[i + 1][j + 1]) {
                check[i + 1][j + 1] = true;
                count3 = maxstep(i + 1, j + 1, rows, cols, grid, check);
            }

            max = Math.max(count1, Math.max(count2, count3));

        }

        return 1 + max;
    }

}