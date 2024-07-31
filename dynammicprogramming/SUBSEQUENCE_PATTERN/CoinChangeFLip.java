class Solution {
    public int coinChange(int[] arr, int T) {
        // Create a 2D array to store results of subproblems
        int n = arr.length;
        int dp[][] = new int[n][T + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        int result = minCoins(arr, n - 1, T, dp);
        
        // If result is infinity, change it to -1 (no solution)
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int minCoins(int[] arr, int ind, int T, int[][] dp) {
        // Base case: If the current index is 0
        if (ind == 0) {
            // If T is divisible by the first element of the array, return number of coins, else return a large number (infinity)
            if (T % arr[0] == 0)
                return T / arr[0];
            else
                return Integer.MAX_VALUE; // Impossible to make the change
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][T] != -1)
            return dp[ind][T];

        // Calculate the number of coins without taking the current element
        int notTaken = minCoins(arr, ind - 1, T, dp);

        // Initialize the number of coins if taking the current element as infinity
        int taken = Integer.MAX_VALUE;

        // If the current element is less than or equal to T, calculate 'taken'
        if (arr[ind] <= T) {
            int res = minCoins(arr, ind, T - arr[ind], dp);
            if (res != Integer.MAX_VALUE) {
                taken = res + 1; // Add 1 to include the current coin
            }
        }

        // Store the result in the dp array and return it
        dp[ind][T] = Math.min(notTaken, taken);
        return dp[ind][T];
    }
}
