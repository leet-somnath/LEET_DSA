<<<<<<< HEAD
import java.util.*;
import java.io.*;

public class Fibonnaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibonnaci(n, dp));// O(N),S(N)+recursionstack
        System.out.println(fibonaci2(n, dp));// O(N),S(N}
        System.out.println(optfibonaci(n));// O(N),S(1)
        sc.close();
    }

    public static int fibonnaci(int n, int[] dp)// RECURSION
    {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fibonnaci(n - 1, dp) + fibonnaci(n - 2, dp);

    }

    public static int fibonaci2(int n, int dp[])// TABULATION
    {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int optfibonaci(int n) {
        int prev = 1;
        int secondprev = 0;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev + secondprev;
            secondprev = prev;
            prev = curr;
        }
        return curr;
    }
=======
import java.util.*;
import java.io.*;

public class Fibonnaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibonnaci(n, dp));// O(N),S(N)+recursionstack
        System.out.println(fibonaci2(n, dp));// O(N),S(N}
        System.out.println(optfibonaci(n));// O(N),S(1)
        sc.close();
    }

    public static int fibonnaci(int n, int[] dp)// RECURSION
    {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fibonnaci(n - 1, dp) + fibonnaci(n - 2, dp);

    }

    public static int fibonaci2(int n, int dp[])// TABULATION
    {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int optfibonaci(int n) {
        int prev = 1;
        int secondprev = 0;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev + secondprev;
            secondprev = prev;
            prev = curr;
        }
        return curr;
    }
>>>>>>> 504a43f5310a405e785594a6b52cb9f857ad9822
}