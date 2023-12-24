import java.util.*;
 import java.io.*;
public class A_Bit {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();  
         int x=0;
         while(n-->0)
         {
            String s=sc.next();
            if(s.contains("++"))
            x++;
            else
            x--;

         }
         System.out.println(x);
        
sc.close();
    }
}