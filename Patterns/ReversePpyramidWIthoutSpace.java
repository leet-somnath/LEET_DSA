import java.util.*;
import java.io.*;

public class ReversePpyramidWIthoutSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c=n*2-1;
        for(int i=0;i<n;i++)
        {
            for(int j=n;j>n-i;j--)
            System.out.print(" ");
            for(int j=0;j<c;j++)
            {
                System.out.print("*");
            }
            c-=2;
     
            System.out.println();
        }
        sc.close();
    }
}
/*
 * 5
*********
 *******
  *****
   ***
    *
 */