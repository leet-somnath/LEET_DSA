/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ISBST {
    private Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root);
    }

    private boolean isValidBSTHelper(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBSTHelper(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return isValidBSTHelper(root.right);
    }
}
