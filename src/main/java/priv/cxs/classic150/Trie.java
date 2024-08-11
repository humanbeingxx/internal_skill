package priv.cxs.classic150;

public class Trie {

    class TrieNode {
        char c;
        boolean leaf;
        TrieNode[] children = new TrieNode[26];

        public TrieNode(char c) {
            this.c = c;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] != null) {
                node = node.children[c - 'a'];
            } else {
                node.children[c - 'a'] = new TrieNode(c);
                node = node.children[c - 'a'];
            }
        }
        node.leaf = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.leaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}
