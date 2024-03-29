class Solution {
    public long countSubarrays(int[] n, int k) {
        int[] st = new int[n.length+2]; int si=1;
        int max=0;
        for(int i=0; i<n.length; i++){
            if(n[i]<max);
            else if(n[i]==max)st[si++]=i;
            else{
                st[1]=i; si=2; max=n[i]; 
            }
        }
        if(si<=k)return 0L;
        st[si]=n.length;

        long ans=0;
        for(int i=k+1; i<=si; i++){
            // System.out.println(i+" "+st[i-k]);
            ans += (long)(st[i-k]+1)*(st[i]-st[i-1]);
        }
        return ans;
    }
}