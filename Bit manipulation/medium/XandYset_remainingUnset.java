import java.io.*;
import java.util.*;

public class XandYset_remainingUnset {
    public static long pow(long x, long a) {
        long ans = 1;
        long m = (long) 1e9 + 7;
        for (int i = 0; (1 << i) <= x; i++) {
            if ((x & (1 << i)) != 0)
                ans = (ans * a) % m;
            a = (a * a) % m;
        }
        return (long) ans % m;
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long m = (long) 1e9 + 7;
        for (int i = 0; i < t; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long a = pow(x, 2) % m;
            long b = pow(y, 2) % m;
            if (a == b)
                System.out.println(a);
            else
                System.out.println((a + b) % m);
        }
    }
}