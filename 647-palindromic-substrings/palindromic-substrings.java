class Solution {
    int result = 0;
    public int countSubstrings(String s) {
        
        for(int i=0; i<s.length(); i++){
            count(s, i, i);
            count(s, i, i+1);
        }
        return result;
    }

    private void count(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            result++;
            start--;
            end++;
        }
    } 
}