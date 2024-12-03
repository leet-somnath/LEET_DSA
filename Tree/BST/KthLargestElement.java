class Solution {
    int pos = 0;

    public int kthLargest(TreeNode root, int k) {
        TreeNode node = reverseInorder(root, k);
        if (node == null) return -1;
        return node.val;
    }

    public TreeNode reverseInorder(TreeNode root, int k) {
        if (root == null) return null;

        // Start with the right subtree for descending order
        TreeNode right = reverseInorder(root.right, k);
        if (right != null) {
            return right;
        }

        // Increment position and check if it's the kth largest
        pos++;
        if (pos == k) {
            return root;
        }

        // Continue with the left subtree
        return reverseInorder(root.left, k);
    }
}
