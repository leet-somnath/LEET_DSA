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
public class BstOperation {
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
    public static void preorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static boolean search(Node root,int x)
    {
        if(root==null)
            return false;
        if(root.val==x)
            return true;
        if(root.val>x)
        {
            return search(root.left,x);
        }
         return search(root.right,x);
    }
    public static Node delete(Node root,int x)
    {
     if(root==null)
         return null;
        if(root.val>x)
            root.left=delete(root.left,x);
        else if(root.val<x)
        {
            root.right=delete(root.right,x);
        }
        else
        {
            if(root.left==null && root.right==null)
                return null;
            if(root.left!=null && root.right==null)
                return root.left;
            if(root.right!=null && root.left==null)
                return root.right;
            int min=fmin(root.right);
            root.val=min;
            root.right=delete(root.right,min);
        }
        return root;
    }
    public static int fmin(Node root)
    {
        if(root==null)
            return Integer.MAX_VALUE;
        return (Math.min(root.val,Math.min(fmin(root.left),fmin(root.right))));
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int y=1;y<=t;y++)
        {
            
            System.out.println("Case "+"#"+y+":");
            int q=sc.nextInt();
           Node root=null;
            for(int i=0;i<q;i++)
            { 
                int type=sc.nextInt();
                
                if(type==1)
                {
int x=sc.nextInt();
                    root=insert(root,x);
                }
                else if(type==2)
                {
                    int x=sc.nextInt();
    root=delete(root,x);
                }
                
                else if(type==3)
                {
                    int x=sc.nextInt();
                        if(search(root,x))
                                System.out.println("Yes");
                        else
                                System.out.println("No");
                }
                else if(type==4)
                {
                    preorder(root);
                    System.out.println();
                }
            }
        
            
        }
        
        
    }
}