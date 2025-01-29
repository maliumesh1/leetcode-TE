class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        Arrays.fill(rank, 0);

        for (int[] edge : edges) {
            if (unionByRank(parent, rank, edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[] {};
    }

    private int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }

    private boolean unionByRank(int[] parent, int[] rank, int u, int v) {
        int parentU = findParent(parent, u);
        int parentV = findParent(parent, v);

        if (parentU == parentV) {
            return true;
        }

        if (rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else if (rank[parentU] < rank[parentV]) {
            parent[parentU] = parentV;
        } else {
            parent[parentV] = parentU;
            rank[parentU]++;
        }
        return false;
    }

}