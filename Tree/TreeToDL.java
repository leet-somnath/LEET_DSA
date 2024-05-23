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
public class TreeToDL {
    static Node prev=null;
    public static Node treetodll(Node root)
    {
        if(root==null)return root;
        Node head=treetodll(root.left);
        if(prev==null)
            head=root;
        else
        {
            root.left=prev;
            prev.right=head;
        }
        prev=root;
        treetodll(root.right);
        return head;
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
        
        
    }
}