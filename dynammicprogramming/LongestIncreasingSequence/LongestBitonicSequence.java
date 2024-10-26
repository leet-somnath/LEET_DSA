import java.util.Arrays;

class LongestBitonicMemoization {

    // Helper function to calculate the longest increasing subsequence ending at each index using memoization
    static int longestIncreasingSubsequence(int[] arr, int n, int ind, int prev_index, int[][] dp1) {
        if (ind == n) {
            return 0;
        }

        if (dp1[ind][prev_index + 1] != -1) {
            return dp1[ind][prev_index + 1];
        }

        int notTake = longestIncreasingSubsequence(arr, n, ind + 1, prev_index, dp1);
        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + longestIncreasingSubsequence(arr, n, ind + 1, ind, dp1);
        }

        dp1[ind][prev_index + 1] = Math.max(notTake, take);
        return dp1[ind][prev_index + 1];
    }

    // Helper function to calculate the longest decreasing subsequence starting from each index using memoization
    static int longestDecreasingSubsequence(int[] arr, int n, int ind, int next_index, int[][] dp2) {
        if (ind == -1) {
            return 0;
        }

        if (dp2[ind][next_index + 1] != -1) {
            return dp2[ind][next_index + 1];
        }

        int notTake = longestDecreasingSubsequence(arr, n, ind - 1, next_index, dp2);
        int take = 0;

        if (next_index == -1 || arr[ind] > arr[next_index]) {
            take = 1 + longestDecreasingSubsequence(arr, n, ind - 1, ind, dp2);
        }

        dp2[ind][next_index + 1] = Math.max(notTake, take);
        return dp2[ind][next_index + 1];
    }

    // Function to find the length of the longest bitonic subsequence using memoization
    static int longestBitonicSequence(int[] arr, int n) {
        int[][] dp1 = new int[n][n + 1]; // For memoization of LIS
        int[][] dp2 = new int[n][n + 1]; // For memoization of LDS

        for (int[] row : dp1) {
            Arrays.fill(row, -1);
        }
        for (int[] row : dp2) {
            Arrays.fill(row, -1);
        }

        // Calculate the longest increasing subsequence (LIS) ending at each index
        for (int i = 0; i < n; i++) {
            longestIncreasingSubsequence(arr, n, i, -1, dp1);
        }

        // Calculate the longest decreasing subsequence (LDS) starting from each index
        for (int i = n - 1; i >= 0; i--) {
            longestDecreasingSubsequence(arr, n, i, -1, dp2);
        }

        // Calculate the longest bitonic subsequence for each index
        int maxBitonic = 0;
        for (int i = 0; i < n; i++) {
            maxBitonic = Math.max(maxBitonic, dp1[i][0] + dp2[i][0] - 1); // Subtract 1 to avoid double-counting the peak element
        }

        return maxBitonic;
    }

    public static void main(String[] args) {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;

        System.out.println("The length of the longest bitonic subsequence is: " +
                longestBitonicSequence(arr, n));
    }
}
