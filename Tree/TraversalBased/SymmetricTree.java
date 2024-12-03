import TreeNode;

package TraversalBased;
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
         if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    queue.offer(node.left);
                    leftList.add(node.left.val);
                } else {
                    leftList.add(null);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                    rightList.add(node.right.val);
                } else {
                    rightList.add(null);
                }
            }
            
            Collections.reverse(rightList);
            
            if (!leftList.equals(rightList)) {
                return false;
            }
        }
        
        return true;
    }
}