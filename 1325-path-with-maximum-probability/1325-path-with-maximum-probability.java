class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        double[] shortPath = new double[n];

        shortPath[start_node] = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean isUpdated = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double wt = succProb[j];

                if (shortPath[u] * wt > shortPath[v]) {
                    shortPath[v] = shortPath[u] * wt;
                    isUpdated = true;
                }

                if (shortPath[v] * wt > shortPath[u]) {
                    shortPath[u] = shortPath[v] * wt;
                    isUpdated = true;
                }
            }
            if (!isUpdated)
                break;
        }
        return shortPath[end_node];
    }

}