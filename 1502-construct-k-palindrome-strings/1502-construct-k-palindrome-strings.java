class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        if (s.length() == k)
            return true;
        int oddcount = 0;
        for (char chr : s.toCharArray()) {
            oddcount ^= 1 << (chr - 'a');
        }

        return Integer.bitCount(oddcount) <= k;
    }

}