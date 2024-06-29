class Solution {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
                List<List<Integer>> res=new ArrayList<>();
                        for(int i=0; i<n; i++){
                                    res.add(new ArrayList<>());
                                            } 

                                                    ArrayList<Integer>[] graph=new ArrayList[n];
                                                            for(int i=0; i<n; i++){
                                                                        graph[i]=new ArrayList<>();
                                                                                }   
                                                                                        for(int[] edge: edges){
                                                                                                    graph[edge[0]].add(edge[1]);
                                                                                                            }
                                                                                                                    for(int i=0; i<n; i++){
                                                                                                                                dfs(graph,i,i,res,new boolean[n]);
                                                                                                                                        }
                                                                                                                                                return res;
                                                                                                                                                    }
                                                                                                                                                        public void dfs( ArrayList<Integer>[] graph, int parent, int curr, List<List<Integer>> res,boolean[] visit){
                                                                                                                                                                visit[curr]=true;
                                                                                                                                                                        for(int i=0; i< graph[curr].size(); i++){
                                                                                                                                                                                    int dest=graph[curr].get(i);
                                                                                                                                                                                                if(!visit[dest]){
                                                                                                                                                                                                                res.get(dest).add(parent);
                                                                                                                                                                                                                                dfs(graph,parent,dest,res,visit);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                        
                                                                                                                                                                                                                                                        }
}