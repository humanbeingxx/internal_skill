package priv.cxs.classic150;

public class WordDictionary {

    class Node {
        char c;
        boolean leaf;
        Node[] children = new Node[26];

        public Node(char c) {
            this.c = c;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node(' ');
    }

    public void addWord(String word) {
        Node node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] != null) {
                node = node.children[c - 'a'];
            } else {
                node.children[c - 'a'] = new Node(c);
                node = node.children[c - 'a'];
            }
        }
        node.leaf = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Node node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.leaf;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Node child : node.children) {
                if (search(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return search(word, index + 1, node.children[c - 'a']);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("."));;
    }
}
