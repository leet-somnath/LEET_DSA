import java.io.*;
import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BstTraversal {
    public static Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (root.val > x)
            root.left = insert(root.left, x);
        else
            root.right = insert(root.right, x);
        return root;
    }

    // In-order traversal to print the BST
    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    // Pre-order traversal to print the BST
    public static void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // Post-order traversal to print the BST
    public static void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        while (t-- > 0) {
            int n = sc.nextInt(); 
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt(); 
            }

            Node root = null;
            for (int i = 0; i < n; i++) {
                root = insert(root, arr[i]); 
            }

            // Print the BST in in-order traversal
            System.out.print("In-order: ");
            inOrderTraversal(root);
            System.out.println();

            // Print the BST in pre-order traversal
            System.out.print("Pre-order: ");
            preOrderTraversal(root);
            System.out.println();

            // Print the BST in post-order traversal
            System.out.print("Post-order: ");
            postOrderTraversal(root);
            System.out.println(); // Print newline for separation
        }
        sc.close(); // Close the scanner
    }
}
