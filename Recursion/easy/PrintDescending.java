import java.util.*;
import java.io.*;

public class PrintDescending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        printdescending(n);
        sc.close();
    }

    public static void printdescending(int n) {
        if(n==0)
        return;

        System.out.println(n);
        printdescending(n-1);

    }
}