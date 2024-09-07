import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int m=(int)1e9+7;
        while(t-->0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            long ans=0;
            for(int i=0;i<32;i++)
            {
                long c=0;
                for(int j=0;j<n;j++)
                {
                    if(checkbit(arr[j],i))
                    {
                        ans=ans+ (c+1)*(n-j)*(1<<i);
                        c=0;
                    }
                    else
                        c++;
                }
            }
            System.out.println(ans);
        }
    }
    public static boolean checkbit(int n,int i)
    {
        if((n&(1<<i))>0)
            return true;
        else
            return false;
    }
}