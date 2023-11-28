import java.util.*;
 import java.io.*;
public class A_Medium_Number {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
int t=sc.nextInt();
while (t-->0) {
    int a=sc.nextInt();
    int b=sc.nextInt();
    int c=sc.nextInt();
    int sum=a+b+c;
    sum=sum-(Math.max(Math.max(a,b),c)+Math.min(Math.min(a,b),c));
    System.out.println(sum);
}
sc.close();
    }
}