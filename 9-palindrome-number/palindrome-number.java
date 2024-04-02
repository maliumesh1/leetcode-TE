class Solution {
    public boolean isPalindrome(int x) {
        int k=0;
        int d=x;
        while(x>0)
        {
            k = k*10 + x%10;
            x=x/10;
        }
        return k==d;
    }
}