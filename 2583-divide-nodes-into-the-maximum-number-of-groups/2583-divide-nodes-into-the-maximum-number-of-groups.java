// import java.util.*;

// class Solution {
//     public int magnificentSets(int n, int[][] edges) {
//         List<List<Integer>> adj = new ArrayList<>();
//         n++; // Increment to use 1-based indexing

//         // Initialize adjacency list
//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         // Build the graph
//         for (int[] edge : edges) {
//             adj.get(edge[0]).add(edge[1]);
//             adj.get(edge[1]).add(edge[0]);
//         }

//         // Step 1: Check if the graph is bipartite
//         if (!isBipartite(adj, n)) {
//             return -1; // If not bipartite, return -1
//         }

//         // Step 2: Compute BFS depth for each node
//         int[] bfsDepth = new int[n];
//         for (int i = 1; i < n; i++) {
//             bfsDepth[i] = bfsDepthFinder(adj, i);
//         }

//         // Step 3: DFS traversal to sum up maximum depths
//         int[] visited = new int[n];
//         int groupCount = 0;
//         for (int i = 1; i < n; i++) {
//             if (visited[i] == 0) {
//                 groupCount += dfs(adj, visited, bfsDepth, i);
//             }
//         }
//         return groupCount;
//     }

//     // DFS to find the maximum depth in the connected component
//     private int dfs(List<List<Integer>> adj, int[] visited, int[] bfsDepth, int node) {
//         visited[node] = 1;
//         int maxDepth = bfsDepth[node];

//         for (int neighbor : adj.get(node)) {
//             if (visited[neighbor] == 0) {
//                 maxDepth = Math.max(maxDepth, dfs(adj, visited, bfsDepth, neighbor));
//             }
//         }
//         return maxDepth;
//     }

//     // BFS to find the depth of a given node
//     private int bfsDepthFinder(List<List<Integer>> adj, int start) {
//         Queue<int[]> queue = new LinkedList<>();
//         queue.add(new int[]{start, 1});
//         int[] visited = new int[adj.size()];
//         visited[start] = 1;
//         int[] last = new int[2];

//         while (!queue.isEmpty()) {
//             last = queue.poll();
//             for (int neighbor : adj.get(last[0])) {
//                 if (visited[neighbor] == 0) {
//                     visited[neighbor] = 1;
//                     queue.add(new int[]{neighbor, last[1] + 1});
//                 }
//             }
//         }
//         return last[1];
//     }

//     // Check if the graph is bipartite
//     private boolean isBipartite(List<List<Integer>> adj, int n) {
//         int[] color = new int[n];
//         for (int i = 0; i < n; i++) {
//             if (color[i] == 0 && !bfsCheck(adj, color, i)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     // BFS helper for bipartite check
//     private boolean bfsCheck(List<List<Integer>> adj, int[] color, int node) {
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(node);
//         color[node] = 1;

//         while (!queue.isEmpty()) {
//             int current = queue.poll();
//             int nextColor = (color[current] == 1) ? 2 : 1;

//             for (int neighbor : adj.get(current)) {
//                 if (color[neighbor] == 0) {
//                     color[neighbor] = nextColor;
//                     queue.add(neighbor);
//                 } else if (color[neighbor] != nextColor) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        n++;
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edg[] : edges) {
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);
        }

        if (!isBipartite(adj, n))
            return -1;

        int degreeBFS[] = new int[n];
        for (int i = 1; i < n; i++)
            degreeBFS[i] = bfsdegree(adj, i);

        int vis[] = new int[n];
        int grp = 0;
        for (int i = 1; i < n; i++)
            if (vis[i] == 0)
                grp += dfs(adj, vis, degreeBFS, i);

        return grp;
    }

    public int dfs(List<List<Integer>> adj, int vis[], int deg[], int vertex) {
        vis[vertex] = 1;
        int componentMax = deg[vertex];
        for (int ver : adj.get(vertex))
            if (vis[ver] == 0)
                componentMax = Math.max(componentMax, dfs(adj, vis, deg, ver));
        return componentMax;
    }

    public int bfsdegree(List<List<Integer>> adj, int vertex) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { vertex, 1 });
        int vis[] = new int[adj.size()];
        vis[vertex] = 1;
        int ele[] = new int[2];
        while (!q.isEmpty()) {
            ele = q.poll();
            for (int ver : adj.get(ele[0]))
                if (vis[ver] == 0) {
                    vis[ver] = 1;
                    q.add(new int[] { ver, ele[1] + 1 });
                }
        }
        return ele[1];
    }

    public boolean isBipartite(List<List<Integer>> adj, int n) {
        int color[] = new int[n];
        for (int i = 0; i < n; i++)
            if (color[i] == 0 && !bfs(adj, color, i))
                return false;
        return true;
    }

    public boolean bfs(List<List<Integer>> adj, int color[], int vertex) {
        color[vertex] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        while (!q.isEmpty()) {
            int ele = q.poll();
            int col = color[ele] == 1 ? 2 : 1;
            for (int ver : adj.get(ele))
                if (color[ver] == 0) {
                    color[ver] = col;
                    q.add(ver);
                } else if (color[ver] != col)
                    return false;
        }
        return true;
    }
}
