class Solution {
    public String customSortString(String order, String s) {
        // move all characters that don't appear in order, and just add
        // them to our returning string
        // now for the rest of the characters in s,
        // we need to count how many times it appears

        // iterate through our pairs
        // and add "letter" x times to our string, where x is the count in s

        int[] sCounts = new int[26];
        for (int i = 0; i < s.length(); ++i){
            sCounts[s.charAt(i)-'a']++;  // increment the count
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < order.length(); ++i){
            char c = order.charAt(i);
            while (sCounts[c - 'a'] > 0){
                builder.append(c);
                sCounts[c-'a']--;
            }
        }
        // add any remaining characters
        for (int i = 0; i < 26;++i){
            while (sCounts[i] > 0){
                builder.append((char)('a'+i));
                sCounts[i]--;
            }
        }

        return builder.toString();
    }
}