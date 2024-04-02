class Solution {
    public boolean isPalindrome(int x) {
        int k=0;
        int d=x;
        while(x>0){
            int r = x%10;
            k = k*10 + r;
            x=x/10;
        }
        return k==d;
    }
}