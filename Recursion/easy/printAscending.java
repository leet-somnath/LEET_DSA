import java.util.*;
import java.io.*;

public class printAscending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = n - 1;

        printascending(n, a);
        sc.close();
    }

    public static void printascending(int n, int a) {
        if (a == -1) {
            return;
        }
        System.out.println(n - a);
        printascending(n, a - 1);

    }
}