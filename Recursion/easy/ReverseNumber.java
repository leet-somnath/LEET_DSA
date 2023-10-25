import java.util.*;
import java.io.*;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        reverse(n);
        System.out.println(sum);
        sc.close();
    }

    static int sum = 0;// global variable

    public static void reverse(int n) {
        if (n == 0)
            return;
        sum = sum * 10 + n % 10;
        reverse(n / 10);

    }
}