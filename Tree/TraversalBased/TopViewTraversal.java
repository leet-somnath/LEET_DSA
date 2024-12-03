package TraversalBased;
import java.util.*;

import TreeNode;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class TopViewTraversal {

    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.val)
            root.left = insert(root.left, key);
        else if (key > root.val)
            root.right = insert(root.right, key);
        return root;
    }

    public static List<Integer> topView(TreeNode root) {
        class Pair {
            TreeNode node;
            int hd;
            Pair(TreeNode n, int h) {
                node = n;
                hd = h;
            }
        }

        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            TreeNode node = temp.node;
            int hd = temp.hd;

            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.val);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        return new ArrayList<>(topViewMap.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            TreeNode root = null;
            for (int i = 0; i < N; i++) {
                int value = sc.nextInt();
                root = insert(root, value);
            }

            List<Integer> result = topView(root);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            if (t < T - 1) {
                System.out.println();
            }
        }
        sc.close();
    }
}
