public class Knapsack {
    // Memoization table
    static int[][] dp;

    // Function to solve the knapsack problem using memoization
    static int knapsack(int[] weights, int[] values, int W, int n) {
        // Base Case: If no items left or capacity is 0
        if (n == 0 || W == 0) {
            return 0;
        }

        // If value is already calculated, return from memo table
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // If the weight of the nth item is more than the capacity W, skip it
        if (weights[n - 1] > W) {
            dp[n][W] = knapsack(weights, values, W, n - 1);
        } else {
            // Otherwise, consider both including and excluding the nth item
            dp[n][W] = Math.max(
                values[n - 1] + knapsack(weights, values, W - weights[n - 1], n - 1),  // Include the nth item
                knapsack(weights, values, W, n - 1)                                    // Exclude the nth item
            );
        }
        
        return dp[n][W];
    }

    // Helper function to initialize memoization table and call the knapsack function
    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};  // Weights of the items
        int[] values = {1, 4, 5, 7};   // Values of the items
        int W = 7;                     // Capacity of the knapsack
        int n = values.length;

        // Initialize the dp table with -1 (indicating uncalculated)
        dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        // Call the knapsack function and print the result
        System.out.println("Maximum value in the knapsack: " + knapsack(weights, values, W, n));
    }
}
