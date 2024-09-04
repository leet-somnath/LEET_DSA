import java.util.*;
 import java.io.*;
public class PyramidWIthoutSpace {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int n=sc.nextInt();
        int c=1;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n-i;j++)
        System.out.print(" ");
        for(int j=0;j<c;j++)
        {

            System.out.print("*");
        }
        c+=2;
        for(int j=0;j<n-i;j++)
        System.out.print(" ");
        System.out.println();
    }       
sc.close();
    }
}