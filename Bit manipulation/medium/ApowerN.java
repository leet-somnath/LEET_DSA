import java.util.*;
import java.io.*;

public class ApowerN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(pow(a,n));
        sc.close();
    }
    public static long pow(long a,long x)
    {
        long ans=1;
        long m=(long)1e9+7;
        for(int i=0;(1<<i)<=x;i++)
        {
            if((x&(1<<i))!=0)
                ans=(ans*a)%m;
            a=(a*a)%m;
        }
        return (long)ans%m;
    }
}