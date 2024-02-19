import java.util.*;
import java.io.*;

public class Gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        gcd(a, b);
        sc.close();
    }

    public static void gcd(int a, int b) {
        if (b == 0) {
            System.out.println(a);
        } else {
            gcd(b, a % b);
        }

    }
}