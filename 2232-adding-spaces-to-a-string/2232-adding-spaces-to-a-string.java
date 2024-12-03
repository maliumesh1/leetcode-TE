class Solution {
    // 100 % -> using Character Array
    public String addSpaces(String s, int[] sp) {
        char[] ch = s.toCharArray();
        char[] ans = new char[s.length() + sp.length];

        int i = 0, c = 0;
        for (int k : sp) {
            while (c < k) {
                ans[i++] = ch[c++];
            }
            ans[i++] = ' ';
        }
        while (c < s.length()) {
            ans[i++] = ch[c++];
        }
        return new String(ans);
    }

}