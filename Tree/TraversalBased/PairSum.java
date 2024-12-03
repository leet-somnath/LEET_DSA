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
    public boolean findTarget(TreeNode root, int k) {
      HashSet<Integer> seen = new HashSet<>();
      return find(root, k, seen);
  }

  private boolean find(TreeNode node, int k, HashSet<Integer> seen) {
      if (node == null) {
          return false;
      }
      if (find(node.left, k, seen)) {
          return true;
      }
      if (seen.contains(k - node.val)) {
          return true;
      } else {
          seen.add(node.val);
      }
      return find(node.right, k, seen);
  }
}