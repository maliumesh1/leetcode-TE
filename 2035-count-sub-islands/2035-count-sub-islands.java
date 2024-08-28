class Solution {
    int n, m;
    int[][] isValid;
    int[] dx = new int[] { -1, 0, 0, 1 };
    int[] dy = new int[] { 0, -1, 1, 0 };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        isValid = new int[n][m];
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isValid[i][j] == 0 && grid2[i][j] == 1) {
                    if (isSubIslands(i, j, grid1, grid2)) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    private boolean isSubIslands(int r, int c, int[][] grid1, int[][] grid2) {
        if (grid1[r][c] != 1) {
            isValid[r][c] = -1;
            return false;
        }
        isValid[r][c] = 1;
        for (int k = 0; k < 4; k++) {
            int nr = r + dx[k];
            int nc = c + dy[k];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                continue;
            if (isValid[nr][nc] == -1) {
                isValid[r][c] = -1;
                return false;
            }
            if (isValid[nr][nc] == 1)
                continue;
            if (grid2[nr][nc] == 1 && !isSubIslands(nr, nc, grid1, grid2)) {
                isValid[r][c] = -1;
                return false;
            }
        }
        return true;

    }
}