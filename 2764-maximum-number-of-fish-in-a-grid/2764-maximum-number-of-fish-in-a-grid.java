class Solution {
    public int findMaxFish(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxsum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    maxsum = Math.max(maxsum, dfs(i, j, grid));
                }

            }
        }
        return maxsum;
    }

    private int dfs(int i, int j, int grid[][]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int count = grid[i][j];

        grid[i][j] = 0;
        count += dfs(i + 1, j, grid);
        count += dfs(i - 1, j, grid);
        count += dfs(i, j + 1, grid);
        count += dfs(i, j - 1, grid);

        return count;
    }

}