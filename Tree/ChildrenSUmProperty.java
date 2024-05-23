class Node {
    int val;
    Node left, right;

    Node(int item) {
        val = item;
        left = right = null;
    }
}

public class ChildrenSUmProperty {
    
    static boolean isChildrenSumProperty(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }

        int leftVal = 0, rightVal = 0;
        
        if (node.left != null) {
            leftVal = node.left.val;
        }
        
        if (node.right != null) {
            rightVal = node.right.val;
        }

        return (node.val == leftVal + rightVal) &&
               isChildrenSumProperty(node.left) &&
               isChildrenSumProperty(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);

        if (isChildrenSumProperty(root)) {
            System.out.println("The tree satisfies the children sum property.");
        } else {
            System.out.println("The tree does not satisfy the children sum property.");
        }
    }
}
