class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
       List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int meet[] : meetings){
            adj.get(meet[0]).add(new pair(meet[1],meet[2]));
            adj.get(meet[1]).add(new pair(meet[0],meet[2]));
        }
        int meetTime[] = new int[n];
         Arrays.fill(meetTime,Integer.MAX_VALUE);
        meetTime[0] = 0;
        meetTime[firstPerson] = 0;
       
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,0));
        q.add(new pair(firstPerson,0));
        
        while(!q.isEmpty()){
            pair pair = q.poll();
            for(pair meet : adj.get(pair.p)){
                if(meet.t>=pair.t&&meetTime[meet.p]>meet.t){
                    meetTime[meet.p] = meet.t;
                    q.add(meet);
                }
            }
        }
        List<Integer> list =  new ArrayList<>();
    
        for(int i=0;i<n;i++){
            if(meetTime[i]!=Integer.MAX_VALUE)
                list.add(i);
        }
        return list;
    }
}
class pair{
    int p;
    int t;
    public pair(int p,int t){
        this.p = p;
        this.t = t;
    }
}