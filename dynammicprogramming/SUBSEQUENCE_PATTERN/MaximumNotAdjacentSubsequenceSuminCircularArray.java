import java.util.*;
import java.io.*;

public class MaximumNotAdjacentSubsequenceSuminCircularArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) { 
            arr[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(arr[0]);
            sc.close();
            return;
        }

        // Get the maximum sum excluding the last element
        int ans1 = maximumseqMemo(arr, 0, n - 2, new int[n - 1]);
        // Get the maximum sum excluding the first element
        int ans2 = maximumseqMemo(arr, 1, n - 1, new int[n - 1]);

        // Return the maximum of both answers
        System.out.println(Math.max(ans1, ans2));
        sc.close();
    }

    // Memoized function to calculate the maximum non-adjacent subsequence sum
    public static int maximumseqMemo(int arr[], int start, int end, int[] dp) {
        // If we've reached out of bounds, return 0 (base case)
        if (start > end) return 0;

        // If already computed, return the stored result
        if (dp[start] != 0) return dp[start];

        // Pick the current element and move two steps ahead
        int pick = arr[start] + maximumseqMemo(arr, start, end-2, dp);

        // Skip the current element and move one step ahead
        int nonPick = maximumseqMemo(arr, start, end-1, dp);

        // Store and return the maximum of picking or not picking the current element
        return dp[start] = Math.max(pick, nonPick);
    }
}
