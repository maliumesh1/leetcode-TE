class Solution {
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
                int[] dt = new int[n];
                        Arrays.fill(dt, -1);//store discovery time array track node visit or not
                                //low[i] is the node's all reachable node's smallest depth in a DFS tree
                                        int[] low = new int[n];
                                                //Create the graph;
                                                        List<Integer>[] graph = new ArrayList[n];
                                                                for (int i = 0; i < n; i++) {
                                                                            graph[i] = new ArrayList<Integer>();
                                                                                    }
                                                                                            for (List<Integer> connection : connections) {
                                                                                                        int from = connection.get(0);
                                                                                                                    int to = connection.get(1);
                                                                                                                                graph[from].add(to);
                                                                                                                                            graph[to].add(from);
                                                                                                                                                    }
                                                                                                                                                            int time=0;
                                                                                                                                                                    //Create the result;
                                                                                                                                                                            List<List<Integer>> result = new ArrayList<>();
                                                                                                                                                                                    //DFS for each node
                                                                                                                                                                                            for (int i = 0; i < n; i++) {
                                                                                                                                                                                                        if(dt[i] == -1) {
                                                                                                                                                                                                                        dfs(i, dt, low, graph, result, -1,time);
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                    return result;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                            private void dfs(int u, int[] dt, int[] low, List<Integer>[] graph, List<List<Integer>> result, int parent,int time) {
                                                                                                                                                                                                                                                                    time++;
                                                                                                                                                                                                                                                                            dt[u] = time;
                                                                                                                                                                                                                                                                                    low[u] = time;
                                                                                                                                                                                                                                                                                            List<Integer> children = graph[u];
                                                                                                                                                                                                                                                                                                    for (int v : children) {
                                                                                                                                                                                                                                                                                                                if (v == parent) {
                                                                                                                                                                                                                                                                                                                                continue;
                                                                                                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                                                                                                            if (dt[v] == -1) {
                                                                                                                                                                                                                                                                                                                                                                                dfs(v, dt, low, graph, result, u,time);
                                                                                                                                                                                                                                                                                                                                                                                                    low[u] = Math.min(low[u], low[v]);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (dt[u]<low[v]) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                result.add(Arrays.asList(u, v));
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        low[u] = Math.min(low[u], dt[v]);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
}