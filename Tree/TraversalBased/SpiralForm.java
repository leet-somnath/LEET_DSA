package TraversalBased;
import java.io.*;
import java.util.*;
class Node {
    int val;
    Node left,right;
    Node(int val) {
        this.val = val;
        this.left = null;
        this.right=null;
    }
}
public class SpiralForm {
    // method 1 direct printing
    public static void printLevel(Node root) {
        if (root == null) {
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean isOdd = true;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                
                if (isOdd) {
                    levelNodes.addFirst(node.val);
                } else {
                    levelNodes.addLast(node.val);
                }
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            for (int val : levelNodes) {
                System.out.print(val + " ");
            }
            
            isOdd = !isOdd;
        }
    }
    // method 2 storing in arraylist
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> levelNodes = new ArrayList<>(levelSize);
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (leftToRight) {
                    levelNodes.add(node.val);
                } else {
                    levelNodes.add(0, node.val);
                }
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            result.add(levelNodes);
            leftToRight = !leftToRight;
        }
        
        return result;
    }
public static Node insert(Node root,int x)
    {
        if(root==null)
            return new Node(x);
        if(root.val>x)
            root.left=insert(root.left,x);
        else
            root.right=insert(root.right,x);
        return root;
    }
   
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
             Node root=null;
            for(int i=0;i<n;i++)
            { 
                root=insert(root,arr[i]);
            }
           
            
        }
        sc.close();
        
    }
}