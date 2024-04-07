import java.util.Scanner;

public class x1sy0s {
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
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        long m = (long) 1e9 + 7;
        for (long i = 0; i < t; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long a = pow(x, 2) % m;
            long b = pow(y, 2) % m;
            System.out.println((a - 1) * b);
        }
    }
}