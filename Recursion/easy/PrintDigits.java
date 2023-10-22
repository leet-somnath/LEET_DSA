import java.util.*;
import java.io.*;

public class PrintDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        printdigits(n);
        sc.close();
    }

    public static void printdigits(int n) {

        if (n == 0)
            return;
        System.out.println(n % 10);
        printdigits(n / 10);

    }

}