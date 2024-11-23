class Solution {
    public String originalDigits(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] count = new int[10];
        count[0] = freq['z' - 'a'];
        count[2] = freq['w' - 'a'];
        count[4] = freq['u' - 'a'];
        count[6] = freq['x' - 'a'];
        count[8] = freq['g' - 'a'];
        count[3] = freq['h' - 'a'] - count[8];
        count[5] = freq['f' - 'a'] - count[4];
        count[7] = freq['s' - 'a'] - count[6];
        count[1] = freq['o' - 'a'] - count[0] - count[2] - count[4];
        count[9] = freq['i' - 'a'] - count[5] - count[6] - count[8];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            while (count[i]-- > 0) {
                res.append(i);
            }
        }
        return res.toString();
    }

}