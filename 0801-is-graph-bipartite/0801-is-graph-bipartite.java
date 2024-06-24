class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] col=new int[graph.length];
        Arrays.fill(col,-1);
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                if(!dfs(i,col,graph)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int[] col,int[][] graph){
        if(col[node]==-1) col[node]=0;
        for(int el:graph[node]){
            if(col[el]==-1){
                col[el]=1-col[node];
                if(!dfs(el,col,graph)) return false; 
            }
            else if(col[el]==col[node]){
                return false;
            }
        }
        return true;
    }
}