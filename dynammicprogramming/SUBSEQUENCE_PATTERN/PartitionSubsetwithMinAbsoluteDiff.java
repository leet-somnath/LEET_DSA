import java.util.*;

public class PartitionSubsetwithMinAbsoluteDiff {

    // Helper function to calculate the minimum absolute difference of two subsets
    static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create a memoization table
        int[][] dp = new int[n][totSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function with memoization
        return subsetSumRecursive(arr, n - 1, 0, totSum, dp);
    }

    // Recursive function with memoization to find the minimum absolute difference
    static int subsetSumRecursive(ArrayList<Integer> arr, int index, int currSum, int totSum, int[][] dp) {
        // Base case: when no more elements are left
        if (index < 0) {
            return Math.abs((totSum - currSum) - currSum);
        }

        // Check if this subproblem is already solved
        if (dp[index][currSum] != -1) {
            return dp[index][currSum];
        }

        // Take the current element
        int take = subsetSumRecursive(arr, index - 1, currSum + arr.get(index), totSum, dp);

        // Don't take the current element
        int notTake = subsetSumRecursive(arr, index - 1, currSum, totSum, dp);

        // Store the result in the memoization table and return the minimum difference
        return dp[index][currSum] = Math.min(take, notTake);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int n = arr.size();

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));
    }
}
