                            
import java.util.ArrayList;

// Node class
// for the Trie
class Node {
    // Array to store links
    // to child nodes (0 and 1)
    Node[] links;
    
    // Constructor
    Node() {
        links = new Node[2];
    }

    // Method to check if a specific
    // bit key is present in the child nodes
    boolean containsKey(int bit) {
        // Returns true if the link at
        // index 'bit' is not null
        return links[bit] != null;
    }

    // Method to get the child node
    // corresponding to a specific bit
    Node get(int bit) {
        // Returns the child
        // node at index 'bit'
        return links[bit];
    }

    // Method to set a child node at a
    // specific index in the links array
    void put(int bit, Node node) {
        // Sets the child node at index
        // 'bit' to the provided node
        links[bit] = node;
    }
}

// Trie class
class Trie {
    // Root node of the Trie
    Node root;

    // Constructor to initialize
    // the Trie with a root node
    Trie() {
        // Creates a new root
        // node for the Trie
        root = new Node();
    }

    // Method to insert a number into the Trie
    void insert(int num) {
        // Start from the root node
        Node node = root;
        // Iterate through each bit of the
        // number (from left to right)
        for (int i = 31; i >= 0; i--) {
            // Extract the i-th bit of the number
            int bit = (num >> i) & 1;

            // If the current node doesn't have a
            // child node with the current bit
            if (!node.containsKey(bit)) {

                // Create a new child node
                // with the current bit
                node.put(bit, new Node());
            }

            // Move to the child node
            // corresponding to the current bit
            node = node.get(bit);
        }
    }

    // Method to find the maximum
    // XOR value for a given number
    int getMax(int num) {
        // Start from the root node
        Node node = root;

        // Initialize the maximum XOR value
        int maxNum = 0;

        // Iterate through each bit of
        // the number (from left to right)
        for (int i = 31; i >= 0; i--) {

            // Extract the i-th
            // bit of the number
            int bit = (num >> i) & 1;

            // If the complement of the current
            // bit exists in the Trie
            if (node.containsKey(1 - bit)) {

                // Update the maximum XOR
                // value with the current bit
                maxNum |= (1 << i);

                // Move to the child node corresponding
                // to the complement of the current bit
                node = node.get(1 - bit);
            } else {

                // Move to the child node
                // corresponding to the current bit
                node = node.get(bit);
            }
        }

        // Return the maximum XOR value
        return maxNum;
    }
}

public class MaximumXOrofTheArray {
    // Function to find the maximum XOR
    // value between two sets of numbers
    static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        // Create a Trie object
        Trie trie = new Trie();
        // Insert each number from
        // the first set into the Trie
        for (int it : arr1) {
            trie.insert(it);
        }

        // Initialize the maximum XOR value
        int maxi = 0;

        // Iterate through each
        // number in the second set
        for (int it : arr2) {
            // Update the maximum XOR value
            // with the result from the Trie
            maxi = Math.max(maxi, trie.getMax(it));
        }
        // Return the
        // maximum XOR value
        return maxi;
    }

    // Function to print the
    // Input Arrays
    static void printArr(ArrayList<Integer> arr) {
        for (int it : arr) {
            System.out.print(it + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(java.util.Arrays.asList(3, 10, 5, 25, 2));
        ArrayList<Integer> arr2 = new ArrayList<>(java.util.Arrays.asList(8, 1, 2, 12, 7));
        int n = arr1.size();
        int m = arr2.size();

        System.out.print("Arr1: ");
        printArr(arr1);
        System.out.print("Arr2: ");
        printArr(arr2);

        int result = maxXOR(n, m, arr1, arr2);
        System.out.println("Maximum XOR value: " + result);
    }
}
                            
                        