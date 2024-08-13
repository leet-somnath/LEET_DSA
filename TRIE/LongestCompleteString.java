class Node {
    Node[] links = new Node[26];
    boolean flag;

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

public class LongestCompleteString {
    Node root;

    public LongestCompleteString() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    String longestCompleteString() {
        return longestCompleteStringUtil(root, "");
    }

    String longestCompleteStringUtil(Node node, String prefix) {
        if (node == null) {
            return "";
        }

        String longest = node.isEnd() ? prefix : "";

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.containsKey(ch)) {
                String current = longestCompleteStringUtil(node.get(ch), prefix + ch);
                if (current.length() > longest.length()) {
                    longest = current;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestCompleteString trie = new LongestCompleteString();
        String[] words = { "a", "ap", "app", "appl", "apple" };

        for (String word : words) {
            trie.insert(word);
        }

        System.out.println("Longest complete string with all prefixes: " + trie.longestCompleteString());
    }
}
