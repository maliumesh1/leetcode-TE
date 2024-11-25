class Solution {
    int min = Integer.MAX_VALUE;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int slidingPuzzle(int[][] board) {
        // grid, moves, last i, last j
        int[] zero = { -1, -1 };
        outer: for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zero = new int[] { i, j };
                    break outer;
                }
            }
        }
        backtrack(board, 0, new int[] { -1, -1 }, zero);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void backtrack(int[][] board, int moves, int[] last, int[] curr) {
        if (moves >= 19)
            return;
        if (isDone(board)) {
            min = Math.min(min, moves);
            return;
        }
        for (int[] dir : dirs) {
            int i = curr[0] + dir[0];
            int j = curr[1] + dir[1];
            // out of bounds or the previous swap
            if (i < 0 || i >= 2 || j < 0 || j >= 3 || (last[0] == i && last[1] == j))
                continue;
            int[] newMove = { i, j };
            flip(board, curr, newMove);
            backtrack(board, moves + 1, curr, newMove);
            flip(board, curr, newMove);
        }
    }

    public void flip(int[][] board, int[] f, int[] s) {
        int temp = board[f[0]][f[1]];
        board[f[0]][f[1]] = board[s[0]][s[1]];
        board[s[0]][s[1]] = temp;
    }

    public boolean isDone(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 2)
                    return true;
                if (board[i][j] != 3 * i + j + 1)
                    return false;
            }
        }
        return true;
    }
}
