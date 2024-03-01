class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') count++;
        }
        StringBuilder sb=new StringBuilder();
        if(count==1){
            for(int i=0;i<s.length()-1;i++){
                sb.append('0');
            }
            sb.append('1');
            return sb.toString();
        }
        else{
            for(int i=0;i<count-1;i++){
                sb.append('1');
            }
            for(int i=0;i<s.length()-count;i++){
                sb.append('0');
            }
            sb.append('1');
            return sb.toString();
        }
    }
}