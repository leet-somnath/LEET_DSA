import java.util.*;
 import java.io.*;
public class A_Wrong_Subtraction {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
               int n=sc.nextInt();
               int k=sc.nextInt();
               while (k-->0) {
                if(n%10!=0)
                n--;
                else
                n=n/10;
               } 
               System.out.println(n);
        
sc.close();
    }
}