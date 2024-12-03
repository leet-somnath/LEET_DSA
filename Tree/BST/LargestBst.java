class Solution {
    class Result {
        boolean isBST;
        int size;
        int min;
        int max;

        Result(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        findLargestBST(root);
        return maxSize;
    }

    private Result findLargestBST(TreeNode node) {
        if (node == null) {
            return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = findLargestBST(node.left);
        Result right = findLargestBST(node.right);

        // Check if the current node forms a valid BST with its left and right subtrees
        if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
            int size = left.size + right.size + 1;
            maxSize = Math.max(maxSize, size);

            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);

            return new Result(true, size, min, max);
        } else {
            return new Result(false, 0, 0, 0);
        }
    }
}
