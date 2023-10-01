import java.util.*;
 import java.io.*;
public class unsetLastSetBit {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int n=sc.nextInt();
        System.out.println(n&(n-1));
sc.close();
    }
}