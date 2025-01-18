class Solution {
    int[] xd = { 0, 0, 1, -1 };
    int[] yd = { 1, -1, 0, 0 };

    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] dis = new int[n][m];
        for (int[] row : dis)
            Arrays.fill(row, Integer.MAX_VALUE);
        dis[0][0] = 0;
        deque.offerFirst(new int[] { 0, 0, 0 });

        while (!deque.isEmpty()) {
            int[] top = deque.pollFirst();
            int cost = top[0], x = top[1], y = top[2];
            if (x == n - 1 && y == m - 1)
                return cost;

            for (int i = 0; i < 4; i++) {
                int nx = x + xd[i], ny = y + yd[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int newCost = cost + (grid[x][y] == i + 1 ? 0 : 1);
                    if (newCost < dis[nx][ny]) {
                        dis[nx][ny] = newCost;
                        if (grid[x][y] == i + 1) {
                            deque.offerFirst(new int[] { newCost, nx, ny });
                        } else {
                            deque.offerLast(new int[] { newCost, nx, ny });
                        }
                    }
                }
            }
        }
        return 0;
    }

}