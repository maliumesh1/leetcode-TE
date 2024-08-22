class Solution {
    public int findComplement(int num) {
        int mask = 1;
        String s = Integer.toBinaryString(num);
        for(int i = 0;i<s.length();i++)
        {
        num = num ^ mask;
        mask= mask<<1;

        }
        return num;
    }
}