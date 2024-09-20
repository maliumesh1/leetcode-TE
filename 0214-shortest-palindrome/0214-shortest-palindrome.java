class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == n) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.substring(i));
        sb.reverse();
        sb.append(shortestPalindrome(s.substring(0, i)));
        sb.append(s.substring(i));
        return sb.toString();
    }

}