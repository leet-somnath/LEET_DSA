                            
// Define a class for the trie data structure
class Trie {
    // Define a struct for
    // each node in the trie
    static class Node {
        // Array to store
        // links to child nodes
        Node[] links;
        // Counter for number of
        // words that end at this node
        int cntEndWith;
        // Counter for number of words
        // that have this node as a prefix
        int cntPrefix;

        // Constructor for Node
        Node() {
            links = new Node[26];
            cntEndWith = 0;
            cntPrefix = 0;
        }

        // Function to check if the
        // node contains a specific key
        boolean containsKey(char ch) {
            // Check if the link corresponding
            // to the character exists
            return links[ch - 'a'] != null;
        }

        // Function to get the child
        // node corresponding to a key
        Node get(char ch) {
            // Return the link
            // corresponding to the character
            return links[ch - 'a'];
        }

        // Function to insert a child
        // node with a specific key
        void put(char ch, Node node) {
            // Set the link corresponding to
            // the character to the provided node
            links[ch - 'a'] = node;
        }

        // Function to increment the
        // count of words that end at this node
        void increaseEnd() {
            // Increment the counter
            cntEndWith++;
        }

        // Function to increment the count of
        // words that have this node as a prefix
        void increasePrefix() {
            // Increment the counter
            cntPrefix++;
        }

        // Function to decrement the count
        // of words that end at this node
        void deleteEnd() {
            // Decrement the counter
            cntEndWith--;
        }

        // Function to decrement the count of
        // words that have this node as a prefix
        void reducePrefix() {
            // Decrement the counter
            cntPrefix--;
        }
    }

    // Pointer to the
    // root node of the trie
    private Node root;

    // Constructor to initialize
    // the trie with an empty root node
    Trie() {
        // Create a new root node
        root = new Node();
    }

    // Function to insert
    // a word into the trie
    void insert(String word) {
        // Start from the root node
        Node node = root;
        // Iterate over each
        // character in the word
        for (int i = 0; i < word.length(); i++) {
            // If the character is
            // not already in the trie
            if (!node.containsKey(word.charAt(i))) {
                // Create a new node
                // for the character
                node.put(word.charAt(i), new Node());
            }
            // Move to the child node
            // corresponding to the character
            node = node.get(word.charAt(i));
            // Increment the prefix
            // count for the node
            node.increasePrefix();
        }
        // Increment the end count
        // for the last node of the word
        node.increaseEnd();
    }

    // Function to count the number
    // of words equal to a given word
    int countWordsEqualTo(String word) {
        // Start from the root node
        Node node = root;
        // Iterate over each character in the word
        for (int i = 0; i < word.length(); i++) {
            // If the character is found in the trie
            if (node.containsKey(word.charAt(i))) {
                // Move to the child node
                // corresponding to the character
                node = node.get(word.charAt(i));
            } else {
                // Return 0 if the
                // character is not found
                return 0;
            }
        }
        // Return the count of
        // words ending at the node
        return node.cntEndWith;
    }

    // Function to count the number of
    // words starting with a given prefix
    int countWordsStartingWith(String word) {
        // Start from the root node
        Node node = root;
        // Iterate over each character in the prefix
        for (int i = 0; i < word.length(); i++) {
            // If the character is found in the trie
            if (node.containsKey(word.charAt(i))) {
                // Move to the child node
                // corresponding to the character
                node = node.get(word.charAt(i));
            } else {
                // Return 0 if the
                // character is not found
                return 0;
            }
        }
        // Return the count of
        // words with the prefix
        return node.cntPrefix;
    }

    // Function to erase a
    // word from the trie
    void erase(String word) {
        // Start from the root node
        Node node = root;
        // Iterate over each
        // character in the word
        for (int i = 0; i < word.length(); i++) {
            // If the character is
            // found in the trie
            if (node.containsKey(word.charAt(i))) {
                // Move to the child node
                // corresponding to the character
                node = node.get(word.charAt(i));
                // Decrement the prefix
                // count for the node
                node.reducePrefix();
            } else {
                // Return if the
                // character is not found
                return;
            }
        }
        // Decrement the end count
        // for the last node of the word
        node.deleteEnd();
    }
}

public class Implementation2 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        System.out.println("Inserting strings 'apple', 'app' into Trie");
        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'app': ");
        System.out.println(trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'app' from trie");
        trie.erase("app");
        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'apple': ");
        System.out.println(trie.countWordsStartingWith("app"));
    }
}
                            
                        