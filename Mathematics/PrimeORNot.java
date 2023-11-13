import java.util.Scanner;

public class PrimeORNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(primeornot(n));
        sc.close();
    }

    public static boolean primeornot(int n) {
        if (n == 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}