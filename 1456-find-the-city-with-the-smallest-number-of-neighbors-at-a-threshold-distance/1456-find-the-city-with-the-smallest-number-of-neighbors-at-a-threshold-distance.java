class Solution {
    public int findTheCity(int n, int[][] edges, int distance) {

        int dis[][] = new int[n][n];

        for (int i = 0; i < dis.length; i++)
            Arrays.fill(dis[i], (int) 1e9);

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            dis[u][v] = w;
            dis[v][u] = w;

        }

        for (int i = 0; i < n; i++)
            dis[i][i] = 0; // node to node 0;

        // implements Floyd-Warshall's algorithm

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][via] + dis[via][j]);
                }
            }
        }

        int minans = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int ans = 0;

            for (int j = 0; j < n; j++) {
                if (dis[i][j] <= distance)
                    ans += 1;
            }
            if (minans >= ans) {
                minans = ans;
                idx = i;
            }
        }
        return idx;
    }
}
