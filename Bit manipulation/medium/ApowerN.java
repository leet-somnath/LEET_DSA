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
/*
 * import java.util.*;
 public class Main{
 public static double myPow(double x, int n) {
    double ans = 1.0;
    long nn = n;
    if (nn < 0) nn = -1 * nn;
    while (nn > 0) {
      if (nn % 2 == 1) {
        ans = ans * x;
        nn = nn - 1;
      } else {
        x = x * x;
        nn = nn / 2;
      }
    }
    if (n < 0) ans = (double)(1.0) / (double)(ans);
    return ans;
  }

    public static void main(String args[])
    {
        System.out.println(myPow(2,10));
    }
 }
 */