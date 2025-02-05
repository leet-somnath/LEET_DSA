import java.util.*;

class LongestCommonSubstring {
    // Recursive function to find the length of the Longest Common Substring
    static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp, int currentLength) {
        // Base case: If either of the strings reaches the beginning, return the current length
        if (ind1 == 0 || ind2 == 0) {
            return currentLength;
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        int tempLength = currentLength;

        // If the characters at the current indices match, extend the substring
        if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
            tempLength = lcsUtil(s1, s2, ind1 - 1, ind2 - 1, dp, currentLength + 1);
        }

        // Update dp table to store the longest substring length ending at (ind1, ind2)
        dp[ind1][ind2] = tempLength;

        // Return the maximum length of the substring found so far
        return Math.max(tempLength,
                Math.max(lcsUtil(s1, s2, ind1 - 1, ind2, dp, 0),
                        lcsUtil(s1, s2, ind1, ind2 - 1, dp, 0)));
    }

    // Wrapper function to find the Longest Common Substring
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the dp array with -1 to indicate unsolved subproblems
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the helper function to compute the LCS
        return lcsUtil(s1, s2, n, m, dp, 0);
    }

    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Compute and print the Longest Common Substring length
        System.out.println("The Length of Longest Common Substring is " + lcs(s1, s2));
    }
}
