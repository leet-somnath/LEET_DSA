import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LeftViewOfTree {
    public List<Integer> leftView(TreeNode root) {
        List<Integer> leftViewList = new ArrayList<>();
        if (root == null)
            return leftViewList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // If i is 0, add the leftmost node of the level to the list
                if (i == 0) {
                    leftViewList.add(node.val); 
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return leftViewList;
    }

    public static void main(String[] args) {
        // Example usage:
        // Constructing a sample binary tree
        //        3
        //       / \
        //      9  20
        //         / \
        //        15  7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LeftViewOfTree leftViewOfTree = new LeftViewOfTree();
        List<Integer> leftViewList = leftViewOfTree.leftView(root);
        System.out.println("Left View of Tree:");
        System.out.println(leftViewList);
    }
}
