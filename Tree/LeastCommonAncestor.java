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
public class LeastCommonAncestor {
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
            int q=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
             Node root=null;
            for(int i=0;i<n;i++)
            { 
                root=insert(root,arr[i]);
            }
            for(int i=0;i<q;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                Node x=new Node(a);
                Node y=new Node(b);
              //  System.out.print(lca(root,x,y)+" ");
                Node ans=lca(root,x,y);
                System.out.print(ans.val+" ");
               
            }
             System.out.println();
            
        }
        
        
    }
    public static Node lca(Node root,Node a,Node b)
    {
        if(root==null)
            return null;
        if(root.val==a.val || root.val==b.val)
            return root;
        Node l=lca(root.left,a,b);
        Node r=lca(root.right,a,b);
        if(l==null)return r;
        if(r==null)return l;
        return root;
        
    }
}