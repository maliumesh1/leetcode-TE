class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            graph[u].add(new int[] { v, i });
            graph[v].add(new int[] { u, i }); // Construct graph with edge indices
        }

        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i != source) {
                dist[i][0] = dist[i][1] = Integer.MAX_VALUE;
            }
        }

        dijkstra(graph, edges, dist, source, 0, 0);
        int delta = target - dist[destination][0];
        if (delta < 0)
            return new int[][] {}; // Not possible to reach the target

        dijkstra(graph, edges, dist, source, delta, 1);
        if (dist[destination][1] < target)
            return new int[][] {}; // Still not possible

        for (int[] edge : edges) {
            if (edge[2] == -1)
                edge[2] = 1; // Set remaining -1 edges to 1
        }
        return edges;
    }

    private void dijkstra(List<int[]>[] graph, int[][] edges, int[][] dist, int source, int delta, int run) {
        int n = graph.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] { source, 0 });
        dist[source][run] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dist[u][run])
                continue;

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0], edgeIndex = neighbor[1];
                int weight = edges[edgeIndex][2];

                if (weight == -1)
                    weight = 1; // Initially consider -1 as 1

                if (run == 1 && edges[edgeIndex][2] == -1) {
                    // Calculate the required weight adjustment for the second run
                    int newWeight = delta + dist[v][0] - dist[u][1];
                    if (newWeight > weight) {
                        edges[edgeIndex][2] = weight = newWeight; // Update edge weight
                    }
                }

                if (dist[v][run] > dist[u][run] + weight) {
                    dist[v][run] = dist[u][run] + weight;
                    pq.add(new int[] { v, dist[v][run] });
                }
            }
        }

    }
}