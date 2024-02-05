class Solution {
    public int firstUniqChar(String s) {
        
        int n = s.length();

        int ans = Integer.MAX_VALUE;

        for(int i='a'; i<='z'; i++){
            int idx = s.indexOf(i);

            if(idx!=-1 && idx==s.lastIndexOf(i)){
                ans = Math.min(ans,idx);
            }
        }

        if(ans==Integer.MAX_VALUE) return -1;
        else return ans;
    }
}