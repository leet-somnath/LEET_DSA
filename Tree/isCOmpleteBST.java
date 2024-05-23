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

public class isCOmpleteBST {

    public static Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (root.val > x)
            root.left = insert(root.left, x);
        else
            root.right = insert(root.right, x);
        return root;
    }

    public static boolean isCompleteBST(Node root) {
        if (root == null)
            return true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean flag = false;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null)
                flag = true;
            else {
                if (flag)
                    return false;
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Node root = null;
            for (int i = 0; i < n; i++) {
                root = insert(root, arr[i]);
            }
            System.out.println(isCompleteBST(root) ? "Yes" : "No");
        }
    }
}
