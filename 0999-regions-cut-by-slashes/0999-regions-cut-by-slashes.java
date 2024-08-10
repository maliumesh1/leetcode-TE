class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        DSU ds = new DSU((n + 1) * (n + 1));
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0 || i == n || j == n) {
                    int col = (n + 1) * i + j;
                    if (col != 0)
                        ds.union(0, col);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    int p1 = (i + 1) * (n + 1) + j;
                    int p2 = i * (n + 1) + j + 1;
                    ds.union(p1, p2);

                } else if (grid[i].charAt(j) == '\\') {
                    int p1 = i * (n + 1) + j;
                    int p2 = (i + 1) * (n + 1) + j + 1;
                    ds.union(p1, p2);
                }
            }
        }
        return ds.count;
    }
}

class DSU {
    int parent[];
    int rank[];
    int count;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        count = 1;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        int para = find(a);
        int parb = find(b);
        if (para == parb) {
            count++;
            return;
        } else {
            if (rank[para] > rank[parb]) {
                parent[parb] = para;
            } else if (rank[para] < rank[parb]) {
                parent[para] = parb;
            } else {
                parent[parb] = para;
                rank[para]++;
            }
        }
    }

}