import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            long ans=0;
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            for(int i=0;i<32;i++){
                long c=0;
                for(int j=0;j<n;j++){
                    if((a[j]&(1<<i))!=0){
                        c++;
                        ans+=(c)*(1<<i);
                    }
                    else
                        c=0;
                }
            }
            System.out.println(ans);
        }
    }
}