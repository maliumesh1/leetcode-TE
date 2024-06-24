class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[numCourses];
        int n=numCourses;
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList();
        for(int i=0;i<prerequisites.length;i++)
        graph[prerequisites[i][0]].add(prerequisites[i][1]);
        boolean[] visited=new boolean[n];
        boolean[] checkcycle=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,graph,visited,checkcycle))
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int idx,List<Integer>[] graph,boolean[] visited,boolean[] checkcycle)
    {
        visited[idx]=checkcycle[idx]=true;
        
        for(int i:graph[idx])
        {
            if(!visited[i])
            {
                if(dfs(i,graph,visited,checkcycle))
                return true;
            }
            else if(checkcycle[i])
            return true;
        }
        return checkcycle[idx]=false;
    }
}