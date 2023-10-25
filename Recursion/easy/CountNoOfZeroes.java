import java.util.*;
 import java.io.*;
public class CountNoOfZeroes {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int n=sc.nextInt();
        System.out.println(countzeroes(n));
sc.close();
    }
    static int c=0;
    public static int countzeroes(int n)
    {

        if(n==0)
        return c;
        if(n%10==0)
        c++;
       return countzeroes(n/10);
    }
}