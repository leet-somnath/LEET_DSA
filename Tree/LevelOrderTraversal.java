import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(levelNodes);
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        // Constructing a sample binary tree
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal lot = new LevelOrderTraversal();
        List<List<Integer>> traversal = lot.levelOrder(root);
        System.out.println("Level Order Traversal:");
        for (List<Integer> level : traversal) {
            for (Integer x : level)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
