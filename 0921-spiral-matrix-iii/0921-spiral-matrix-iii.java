class Solution {
    int[][] res;

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        res = new int[R * C][2];
        boolean[][] visited = new boolean[R + 2][C + 2];
        walker(visited, 0, R, C, r0 + 1, c0 + 1, 1, true);
        return res;
    }

    // move means +1 or -1 on X or Y based on vertical or not
    public void walker(boolean[][] visited, int n, int R, int C, int x, int y, int move, boolean vertical) {
        if (n == R * C)
            return;
        if (x <= R && x >= 1 && y >= 1 && y <= C) {
            visited[x][y] = true;
            res[n++] = new int[] { x - 1, y - 1 };
            if (vertical) {
                y = y + move;
                while (visited[x + move][y]) {
                    visited[x][y] = true;
                    res[n++] = new int[] { x - 1, y - 1 };
                    y = y + move;
                }
                walker(visited, n, R, C, x, y, move, false);
            } else {
                x = x + move;
                while (visited[x][y - move]) {
                    visited[x][y] = true;
                    res[n++] = new int[] { x - 1, y - 1 };
                    x = x + move;
                }
                walker(visited, n, R, C, x, y, -move, true);
            }
        } else {
            if (vertical) {
                while (visited[x + move][y]) {
                    y = y + move;
                }
                walker(visited, n, R, C, x + move, y, move, false);
            } else {
                while (visited[x][y - move]) {
                    x = x + move;
                }
                walker(visited, n, R, C, x, y - move, -move, true);
            }
        }
    }

}