class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        // Initialize disjoint set data structure with n nodes
        for (int i = 0; i <= n; i++) {
            rank.add(0);       // Initialize rank of each node to 0
            parent.add(i);     // Initialize parent of each node to itself
            size.add(1);       // Initialize size of each component to 1
        }
    }

    public int findUPar(int node) {
        // Find the ultimate parent of a node
        if (node == parent.get(node)) {
            return node;    // Node is its own parent, return itself
        }
        int ulp = findUPar(parent.get(node)); // Recursively find the ultimate parent
        parent.set(node, ulp); // Path compression - set parent to the ultimate parent
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return; // They are already in the same component
        if (size.get(ulp_u) < size.get(ulp_v)) {
            // Attach the smaller component (ulp_u) to the larger component (ulp_v)
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); // Update the size
        } else {
            // Attach the smaller component (ulp_v) to the larger component (ulp_u)
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v)); // Update the size
        }
    }
}

class Solution {
    private boolean isValid(int adjr, int adjc, int n){
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < n;
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        // Build the disjoint set based on the grid
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;

                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};

                for(int ind = 0; ind < 4; ind++){
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if(isValid(newr, newc, n) && grid[newr][newc] == 1){
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        int mx = 0;

        // Traverse the grid to find the largest island size
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1) continue;

                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};

                HashSet<Integer> components = new HashSet<>();
                for(int ind = 0; ind < 4; ind++){
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if(isValid(newr,newc,n) && grid[newr][newc] == 1){
                        if(grid[newr][newc] == 1){
                            components.add(ds.findUPar(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;

                for(Integer parents: components){
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTotal + 1); // Add 1 for the current cell
            }
        }

        // Find the maximum component size in the disjoint set
        for(int cellNo = 0; cellNo < n; cellNo++){
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
        }
        return mx; // Return the largest island size
    }
}