import java.util.*;
 import java.io.*;
public class Msb {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int N=sc.nextInt();
        int msb = (int)(Math.log(N) / Math.log(2));
 System.out.println(msb);
sc.close();
    }
}