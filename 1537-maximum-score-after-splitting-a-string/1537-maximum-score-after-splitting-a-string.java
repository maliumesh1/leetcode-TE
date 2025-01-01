class Solution {
    public int maxScore(String s) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                one++;
        }
        int max = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0')
                zero++;
            else if (s.charAt(i) == '1')
                one--;
            max = Math.max(max, zero + one);
        }
        return max;
    }

}