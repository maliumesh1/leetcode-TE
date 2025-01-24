class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int len = graph.length;

        boolean vis[] = new boolean[len];

        boolean inrecur[] = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (!vis[i]) {
                boolean flag = task(graph, i, vis, inrecur);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (!inrecur[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean task(int[][] adj, int i, boolean vis[], boolean inrecur[]) {

        vis[i] = inrecur[i] = true;

        for (int p : adj[i]) {
            if (!vis[p] && task(adj, p, vis, inrecur)) {
                return true;
            }

            if (inrecur[p]) {
                return true;
            }
        }

        inrecur[i] = false;

        return false;

    }
}