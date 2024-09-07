import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
        while(t-->0)
        {
            int n,m,k;
            
            
           
            n=sc.nextInt();
            long arr[]=new long[n]; 
            for(int i=0;i<n;i++)
                arr[i]=sc.nextLong();
             m=sc.nextInt();
            long b[]=new long[m];
            for(int i=0;i<m;i++)
                b[i]=sc.nextLong();
             k=sc.nextInt();
            long c[]=new long[k];
            for(int i=0;i<k;i++)
                c[i]=sc.nextLong();
            Arrays.sort(arr);
            Arrays.sort(b);
            Arrays.sort(c);
            int p1=0,p2=0,p3=0;
            long ans=Integer.MAX_VALUE;
            while(p1<n && p2<m && p3<k)
            {
                
               long max=Math.max(arr[p1],Math.max(b[p2],c[p3]));
                long min=Math.min(arr[p1],Math.min(b[p2],c[p3]));
                ans=Math.min(ans,(max-min));
                if(arr[p1]==min)
                    p1++;
                else if(b[p2]==min)
                    p2++;
                else
                    p3++;
            }
            System.out.println(ans);
        }
    }
}