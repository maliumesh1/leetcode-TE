class Solution {
    public int prefixCount(String[] words, String pref) {
        int j = pref.length();
        int c = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= j) {
                String s = words[i].substring(0, j);

                if (s.equals(pref)) {
                    c++;
                }
            }

        }
        return c;
    }

}