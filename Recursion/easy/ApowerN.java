import java.util.*;
import java.io.*;

public class ApowerN {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int a=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(power(a,n));
        
sc.close();
    }

    /*
     * public static int power(int a,int n)
     * {
     * 
     * if(n==1)
     * return a;
     * return(a*power(a, n-1));
     * }
     * 
     */
 public static int power(int a,int n)
 {

    //o(logn)
     if(n==1) 
     return a;
     int p=power(a,n/2);
     if((n&1)==0)
     {
        return p*p;
     }
     return a*p*p;
 }




}