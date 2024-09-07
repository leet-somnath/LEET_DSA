import java.io.*;
import java.util.*;

public class LargestPalindromeSubstring{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            String s=sc.next();
            int max=1;
            
            for(int i=0;i<n;i++)
            {
                int p1=i,p2=i;
                while(p1>=0 &&  p2<n)
                {
                    if(s.charAt(p1)==(s.charAt(p2)))
                    {
                        p1--;
                        p2++;
                    }
                    else 
                        break;
                }
                max=Math.max(max,p2-p1-1);
                p1=i;
                p2=i+1;
                 while(p1>=0 &&  p2<n)
                {
                    if(s.charAt(p1)==(s.charAt(p2)))
                    {
                        p1--;
                        p2++;
                    }
                    else 
                        break;
                }
                max=Math.max(max,p2-p1-1);
            }
            System.out.println(max);
            
        }
    }
}