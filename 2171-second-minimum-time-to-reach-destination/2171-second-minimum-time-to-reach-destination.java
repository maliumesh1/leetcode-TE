class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        dist1[1] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 1, 1 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], freq = current[1];
            int t = (freq == 1) ? dist1[x] : dist2[x];

            if ((t / change) % 2 != 0) {
                t = change * ((t / change) + 1) + time;
            } else {
                t += time;
            }

            for (int y : graph.get(x)) {
                if (dist1[y] == -1) {
                    dist1[y] = t;
                    queue.offer(new int[] { y, 1 });
                } else if (dist2[y] == -1 && dist1[y] != t) {
                    if (y == n) {
                        return t;
                    }
                    dist2[y] = t;
                    queue.offer(new int[] { y, 2 });
                }
            }
        }

        return 0;
    }

}