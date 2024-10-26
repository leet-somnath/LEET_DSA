import java.util.*;

class MinimumInsertiontoMakePalindrome {
    // Function to find the LCS using memoization
    static int lcsMemo(String s1, String s2, int n, int m, int[][] dp) {
        // Base case: if one string is empty, LCS is 0
        if (n == 0 || m == 0) {
            return 0;
        }

        // Check if the value is already computed and stored in dp array
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // If characters match, move diagonally and add 1
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + lcsMemo(s1, s2, n - 1, m - 1, dp);
        } else {
            // Otherwise, take the maximum of removing one character either from s1 or s2
            dp[n][m] = Math.max(lcsMemo(s1, s2, n - 1, m, dp), lcsMemo(s1, s2, n, m - 1, dp));
        }

        return dp[n][m];
    }

    // Function to find the Longest Palindromic Subsequence using memoization
    static int longestPalindromeSubsequence(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int n = s.length();

        // Create a memoization table initialized to -1
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Find the LCS of the original string and its reverse
        return lcsMemo(s, reversed, n, n, dp);
    }

    // Function to find the minimum insertions required to make the string palindrome
    static int minInsertion(String s) {
        int n = s.length();
        int k = longestPalindromeSubsequence(s);

        // The minimum insertions required is the difference between the string length and its Longest Palindromic Subsequence length
        return n - k;
    }

    public static void main(String[] args) {
        String s = "abcaa";
        System.out.println("The Minimum insertions required to make the string palindrome: " + minInsertion(s));
    }
}
