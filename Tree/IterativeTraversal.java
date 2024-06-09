import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public void iterativeInorderTraversal() {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.val + " ");

            curr = curr.right;
        }
    }

    public void iterativePreorderTraversal() {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.print(curr.val + " ");

            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }

    public void iterativePostorderTraversal() {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Stack<Integer> resultStack = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            resultStack.push(curr.val);

            if (curr.left != null)
                stack.push(curr.left);
            if (curr.right != null)
                stack.push(curr.right);
        }

        while (!resultStack.isEmpty()) {
            System.out.print(resultStack.pop() + " ");
        }
    }
}

public class IterativeTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Iterative Inorder traversal:");
        tree.iterativeInorderTraversal();
        System.out.println("\nIterative Preorder traversal:");
        tree.iterativePreorderTraversal();
        System.out.println("\nIterative Postorder traversal:");
        tree.iterativePostorderTraversal();
    }
}
