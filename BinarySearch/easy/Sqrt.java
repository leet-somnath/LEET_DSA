import java.util.*;
 import java.io.*;
public class Sqrt {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int n=sc.nextInt();

System.out.println(sqrt(n));

        sc.close();

    }
    public static int sqrt(int n)
    {

           int low=0,end=n,mid=-1;
           while(low<=end)
           {
               mid=low+ (end-low)/2;
              if(mid*mid==n)
              {
                  return mid;
              }
              else if(mid*mid<n)
              {
                  low=mid+1;
              }
              else
              {
                  end=mid-1;
              }


           }
           return Math.round(end);

    }
}