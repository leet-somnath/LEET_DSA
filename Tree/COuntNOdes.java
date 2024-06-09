public /**
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
class COuntNOdes {
   public int countNodes(TreeNode root) {
       if(root == null)
       return 0;
       else{
           int lh = leftHeight(root);
           int rh = rightHeight(root);
           if(lh == rh)
           // no of node at height h in complete binary tree is 2^h-1
           return (int) Math.pow(2,lh) - 1;
           else
           return 1 + countNodes(root.left) + countNodes(root.right);
       }
   }

   public int leftHeight(TreeNode root) {
      int count = 0;
      while(root!= null)
      {
       count++;
       root= root.left;
      }
      return count;
   }

   public int rightHeight(TreeNode root) {
       int count = 0;
      while(root!= null)
      {
       count++;
       root= root.right;
      }
      return count;
   }
} {
    
}
