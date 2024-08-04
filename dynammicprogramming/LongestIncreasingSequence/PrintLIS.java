import java.util.*;

class PrintLIS {
    // Function to find the length of the longest increasing subsequence and store elements
    static int getAns(int arr[], int n, int ind, int prev_index, int[][] dp, List<Integer> seq) {
        // Base condition
        if (ind == n) {
            return 0;
        }

        if (dp[ind][prev_index + 1] != -1) {
            return dp[ind][prev_index + 1];
        }

        List<Integer> notTakeSeq = new ArrayList<>(seq);
        int notTake = getAns(arr, n, ind + 1, prev_index, dp, notTakeSeq);

        List<Integer> takeSeq = new ArrayList<>(seq);
        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            takeSeq.add(arr[ind]);
            take = 1 + getAns(arr, n, ind + 1, ind, dp, takeSeq);
        }

        if (take > notTake) {
            seq.clear();
            seq.addAll(takeSeq);
        } else {
            seq.clear();
            seq.addAll(notTakeSeq);
        }

        dp[ind][prev_index + 1] = Math.max(notTake, take);

        return dp[ind][prev_index + 1];
    }

    // Function to find the length of the longest increasing subsequence
    static List<Integer> longestIncreasingSubsequence(int arr[], int n) {
        int dp[][] = new int[n][n + 1];
        
        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        List<Integer> seq = new ArrayList<>();
        getAns(arr, n, 0, -1, dp, seq);

        return seq;
    }

    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        List<Integer> result = longestIncreasingSubsequence(arr, n);
        System.out.println("The longest increasing subsequence is " + result);
    }
}
