class Solution {
    public String removeDuplicateLetters(String s) {
        char arr[]=s.toCharArray();
        int last[]=new int[26];
        int n=arr.length;
        for(int i=0;i<n;i++) last[arr[i]-'a']=i;
        boolean map[]=new boolean[26];
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            int x=ans.length();
            while(x>0 && !map[arr[i]-'a'] && ans.charAt(x-1)>arr[i] && last[ans.charAt(x-1)-'a']>i){
                map[ans.charAt(x-1)-'a']=false;
                ans.deleteCharAt(x-1);
                x=ans.length();
            }
            if(!map[arr[i]-'a']) ans.append(arr[i]);
            map[arr[i]-'a']=true;
        }
        return ans.toString();
    }
}