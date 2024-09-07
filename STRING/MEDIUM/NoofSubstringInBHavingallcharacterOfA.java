import java.io.*;
import java.util.*;

public class NoofSubstringInBHavingallcharacterOfA {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            String a=sc.next();
            String b=sc.next();
            int n=b.length();
           int ans=b.length();
            int p1=0,p2=0;
            int flag=0;
            while(p1 <n && p2 < n && p1<=p2)
            {
                
                if(isvalid(a,b,p1,p2))
                {
                    ans=Math.min(ans,p2-p1+1);
                    flag=1;
                  p1++;
                    
                }
                else
                {
                    p2++;
                    
                }
                
            }
            if(flag==1)
            System.out.println(ans);
            else
                System.out.println(-1);
        }
    }
    public static boolean isvalid(String a,String b,int p1,int p2)
    {
         int cnta[]=new int [26];
         for(int i=0;i<a.length();i++)
            {
                cnta[a.charAt(i)-97]++;
            }
        
         int cntb[]=new int [26];
            for(int i=p1;i<=p2;i++)
            {
                cntb[b.charAt(i)-97]++;
            }
        
        for(int i=0;i<26;i++)
        {
            if(!(cnta[i]<=cntb[i]))
            {
               return false;
            }
            
        }
        return true;
        
    }
    
}