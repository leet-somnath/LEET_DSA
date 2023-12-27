import java.util.*;
import java.io.*;

public class A_New_Year_and_Hurry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n=sc.nextInt();
         int k=sc.nextInt();
         int s=0,c=0;
         for (int i = 1; i <=n; i++) {
            s+=5*i;
            if(s+k<=240)
            c++;
           
         }
         System.out.println(c);
        sc.close();
    }
}