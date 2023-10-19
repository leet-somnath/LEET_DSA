import java.util.*;
import java.io.*;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
         System.out.println(sumn(n));
        sc.close();
    }
    public static int sumn(int n)
    {
        if(n==1)
        return 1;
        return(n+sumn(n-1));
    }
}