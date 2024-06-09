public class MaximumPathSUm {
    int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxSum(root);
        return maxSum;
    }
    
    private int findMaxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = Math.max(findMaxSum(node.left), 0);
        int rightSum = Math.max(findMaxSum(node.right), 0);
        
        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);
        
        return node.val + Math.max(leftSum, rightSum);
    }
}
 {
    
}
