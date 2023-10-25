import java.util.*;
import java.io.*;

public class ProductsOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(productdigit(n));
        sc.close();

    }

    public static int productdigit(int n) {

        if (n == 0)
            return 0;

        return (n % 10) + productdigit(n / 10);
    }
}