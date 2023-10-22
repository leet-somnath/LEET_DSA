import java.util.*;
 import java.io.*;
public class Summation {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println(sum(n,m));

sc.close();
    }


    public static int sum(int n,int m){
        if (m == 1)
        return (n * (n + 1) / 2);
 
    int sum = sum(n, m - 1);
     
    return (sum * (sum + 1) / 2);       
    }
}