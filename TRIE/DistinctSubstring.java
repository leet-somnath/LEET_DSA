                                
import java.util.HashMap;

// Node structure representing
// each node in the trie
class Node {
    Node[] links;  
    // Array of pointers to child nodes,
    // each corresponding to a letter
    // of the alphabet
    boolean flag;  
    // Flag indicating if the current
    // node represents the end of a substring

    // Method to check if a specific character key
    // exists in the children of the current node
    public boolean containsKey(char ch) {  
        // Check if the current node has a child node
        // corresponding to character 'ch'
        return links[ch - 'a'] != null;
    }

    // Method to get the child node corresponding
    // to a specific character key
    public Node get(char ch) {  
        // Get the child node
        // corresponding to character 'ch'
        return links[ch - 'a'];
    }

    // Method to insert a new child
    // node with a specific character key
    public void put(char ch, Node node) {  
        // Insert a new child
        // node for character 'ch'
        links[ch - 'a'] = node;
    }

    // Method to mark the current
    // node as the end of a substring
    public void setEnd() {  
        // Mark the current node
        // as the end of a substring
        flag = true;
    }

    // Method to check if the current
    // node marks the end of a substring
    public boolean isEnd() {  
        // Check if the current node
        // marks the end of a substring
        return flag;
    }
}

// Function to count the number of
// distinct substrings in the given string
public class DistinctSubstring {  
    // Function to count the number of
    // distinct substrings in the given string
    public static int countDistinctSubstrings(String s) {  
        // Function to count distinct
        // substrings in the input string 's'
        Node root = new Node();  
        // Creating the root
        // node of the trie
        int cnt = 0;  
        // Counter to keep track
        // of distinct substrings
        int n = s.length();  
        // Length of the input string

        // Nested loops to iterate through all
        // possible substrings of the input string
        for (int i = 0; i < n; i++) {  
            // Iterate through each
            // starting position of the substring
            Node node = root;  
            // Start from the root for each substring
            for (int j = i; j < n; j++) {  
                // Iterate through each character of the substring
                // If the current character is not a child
                // of the current node, insert it as a new child node
                if (!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Node());  
                    // Insert a new child
                    // node for character s.charAt(j)
                    cnt++;  
                    // Increment the counter
                    // since a new substring is found
                }
                node = node.get(s.charAt(j));  
                // Move to the child node
                // corresponding to character s.charAt(j)
            }
        }
        return cnt + 1;  
        // Return the total count of distinct substrings
        // (+1 to account for the input string itself)
    }

    // Main function to test the
    // countDistinctSubstrings function
    public static void main(String[] args) {  
        String s = "striver";  
        // Input string
        System.out.println("Current String: " + s);
        System.out.println("Number of distinct substrings: " + countDistinctSubstrings(s));  
        // Output the result
    }
}
                                
                            