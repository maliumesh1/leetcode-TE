class Solution {
    public int compress(char[] chars) {
        int i=0;
        int n= chars.length;
         StringBuilder sb = new StringBuilder();
        while(i<n){
            int j=i+1;
            while(j<n && chars[i]==chars[j]){
                j++;
            }
            sb.append(chars[i]);
            int count =j-i;

            if(count>1){
                sb.append(count);
                }
                i=j;
            } char[] comp = sb.toString().toCharArray();
               for(int j=0;j<comp.length;j++){
               chars[j]=comp[j];
        } return comp.length;
    
    }
}