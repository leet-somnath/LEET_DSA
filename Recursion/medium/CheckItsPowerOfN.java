import java.util.*;
import java.io.*;

public class CheckItsPowerOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(ispower(num, n));

        sc.close();
    }

    public static boolean ispower(int num, int n) {
        if (num == 1)
            return true;
        if ((num % n) != 0 || num == 0)
            return false;
        else
            return ispower(num / n, n);

    }

}