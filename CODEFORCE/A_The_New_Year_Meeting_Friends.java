import java.util.Scanner;
public class A_The_New_Year_Meeting_Friends {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int maximum=Math.max(a,Math.max(b,c));
        int minimum=Math.min(a,Math.min(b,c));
        System.out.println(maximum-minimum);
sc.close();
    }
}