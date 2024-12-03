import java.util.*;

import TraversalBased.TreeNode;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class DiameterOfBST {
    
    static int diameter;
    
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        diameter = Math.max(diameter, leftHeight + rightHeight + 1);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static int findDiameter(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            TreeNode root = null;
            
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                root = insert(root, val);
            }
            
            int result = findDiameter(root);
            System.out.println(result);
        }
        
        sc.close();
    }
}
