import java.util.*;
import java.io.*;

public class Fibonnaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(fib(n));
        sc.close();
    }

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return 1;
        return (fib(n - 1) + fib(n - 2));
    }

}