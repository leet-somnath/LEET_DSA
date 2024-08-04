import java.util.Arrays;

public class RodCutting {

    public static int f(int ind, int N, int[] price, int[][] dp) {
        if (ind == 0) {
            return N * price[0];
        }
        if (dp[ind][N] != -1) return dp[ind][N];
        int notTake = f(ind - 1, N, price, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (rodLength <= N) {
            take = price[ind] + f(ind, N - rodLength, price, dp);
        }
        return dp[ind][N] = Math.max(take, notTake);
    }

    public static int cutRod(int[] price, int n) {
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, n, price, dp);
    }

    public static void main(String[] args) {
        int[] price = {2, 5, 7, 8, 10}; // Example prices
        int n = price.length;
        System.out.println("Maximum obtainable value is: " + cutRod(price, n));
    }
}
