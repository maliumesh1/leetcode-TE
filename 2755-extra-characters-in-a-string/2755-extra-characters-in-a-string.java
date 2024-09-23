class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie(dictionary);
        return extras(0, s, trie, new Integer[s.length()]);
    }

    public int extras(int idx, String s, Trie trie, Integer[] cache) {
        if (idx == s.length()) {
            return 0;
        }
        if (cache[idx] != null) {
            return cache[idx];
        }
        int res = 1 + extras(idx + 1, s, trie, cache);
        TrieNode node = trie.root;
        for (int i = idx; i < s.length(); i++) {
            char ch = s.charAt(i);
            node = node.children[ch - 'a'];
            if (node == null) {
                break;
            }
            if (node.isWord) {
                res = Math.min(res, extras(i + 1, s, trie, cache));
            }
        }
        cache[idx] = res;
        return res;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public Trie(String[] words) {
            for (String word : words) {
                insert(word);
            }
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.isWord = true;
        }
    }

}