import java.util.Arrays;

public class MinimumCoinChange {
    public static int coinChange(int[] coins, int amount) {
        // Create a memoization table for the DP solution
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Start solving from the first index
        int result = helper(coins, coins.length - 1, amount, memo);

        // If the result is Integer.MAX_VALUE, no solution exists
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int[] coins, int index, int amount, int[][] memo) {
        // Base cases
        if (amount == 0) return 0; // No coins are needed to make 0
        if (index < 0) return Integer.MAX_VALUE; // Not possible if no coins are left

        // Check memoization table
        if (memo[index][amount] != -1) return memo[index][amount];

        // Option 1: Do not pick the current coin
        int noPick = helper(coins, index - 1, amount, memo);

        // Option 2: Pick the current coin (if amount >= coins[index])
        int pick = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int subResult = helper(coins, index, amount - coins[index], memo);
            if (subResult != Integer.MAX_VALUE) {
                pick = subResult + 1;
            }
        }

        // Take the minimum of the two options
        memo[index][amount] = Math.min(pick, noPick);

        return memo[index][amount];
    }

    public static void main(String[] args) {
        // Test case
        int[] coins = {1, 3, 5, 7, 9, 11};
        int amount = 15;

        int result = coinChange(coins, amount);
        System.out.println("Minimum coins required: " + result);
    }
}
