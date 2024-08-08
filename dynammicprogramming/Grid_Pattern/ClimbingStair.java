import java.util.*;
import java.io.*;

public class ClimbingStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(climbstar(arr));
        System.out.println(climbstars(arr));
        System.out.println(climbstarRecursive(arr));
        sc.close();
    }

    public static int climbstar(int[] A) {
        int n = A.length;
        if (n == 1) return A[0];
        int dp[] = new int[n];
        dp[0] = A[0];
        dp[1] = A[0] + A[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + A[i];
        }
        return dp[n - 1];
    }

    public static int climbstars(int[] A) {
        int n = A.length;
        if (n == 1) return A[0];
        int secondprev = A[0], prev = A[0] + A[1];
        for (int i = 2; i < n; i++) {
            int curr = Math.min(prev, secondprev) + A[i];
            secondprev = prev;
            prev = curr;
        }
        return prev;
    }

    public static int climbstarRecursive(int[] A) {
        int n = A.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return climbHelper(A, n - 1, memo);
    }

    private static int climbHelper(int[] A, int i, int[] memo) {
        if (i < 0) return Integer.MAX_VALUE;
        if (i == 0) return A[0];
        if (i == 1) return A[0] + A[1];
        if (memo[i] != -1) return memo[i];

        memo[i] = A[i] + Math.min(climbHelper(A, i - 1, memo), climbHelper(A, i - 2, memo));
        return memo[i];
    }
}
=======
import java.util.*;
import java.io.*;

public class ClimbingStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(climbstar(arr));
        System.out.println(climbstars(arr));
        System.out.println(climbstarRecursive(arr));
        sc.close();
    }

    public static int climbstar(int[] A) {
        int n = A.length;
        if (n == 1) return A[0];
        int dp[] = new int[n];
        dp[0] = A[0];
        dp[1] = A[0] + A[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + A[i];
        }
        return dp[n - 1];
    }

    public static int climbstars(int[] A) {
        int n = A.length;
        if (n == 1) return A[0];
        int secondprev = A[0], prev = A[0] + A[1];
        for (int i = 2; i < n; i++) {
            int curr = Math.min(prev, secondprev) + A[i];
            secondprev = prev;
            prev = curr;
        }
        return prev;
    }

    public static int climbstarRecursive(int[] A) {
        int n = A.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return climbHelper(A, n - 1, memo);
    }

    private static int climbHelper(int[] A, int i, int[] memo) {
        if (i < 0) return Integer.MAX_VALUE;
        if (i == 0) return A[0];
        if (i == 1) return A[0] + A[1];
        if (memo[i] != -1) return memo[i];

        memo[i] = A[i] + Math.min(climbHelper(A, i - 1, memo), climbHelper(A, i - 2, memo));
        return memo[i];
    }
}
>>>>>>> 504a43f5310a405e785594a6b52cb9f857ad9822
