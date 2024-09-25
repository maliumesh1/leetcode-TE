class Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            addInTrie(w, root);
        }
        int output[] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int sum = 0;
            TrieNode curr = root;
            for (char c : words[i].toCharArray()) {
                curr = curr.childs[c - 'a'];
                sum = sum + curr.freq;
            }
            output[i] = sum;
        }
        return output;
    }

    private void addInTrie(String w, TrieNode root) {
        char[] arr = w.toCharArray();
        TrieNode curr = root;
        for (char c : arr) {
            if (curr.childs[c - 'a'] == null) {
                curr.childs[c - 'a'] = new TrieNode();
            }
            curr.childs[c - 'a'].freq++;
            curr = curr.childs[c - 'a'];
        }
    }

}

class TrieNode {
    public int freq = 0;
    TrieNode[] childs = null;

    public TrieNode() {
        childs = new TrieNode[26];
    }

}