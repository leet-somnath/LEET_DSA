import java.util.*;

public class MinimumCutsForPalindromePartioning {

    // Function to check if the string s[start...end] is palindrome or not.
    static boolean isPalindrome(char s[], int start, int end) {
        while (start < end) {
            if (s[start++] != s[end--])
                return false;
        }
        return true;
    }

    // Function to find minimum cut for palindrome partitioning of s.
    static int minimumCut(char s[], int index, int[] dp) {
        if (index == s.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = index; i < s.length; i++) {
            if (isPalindrome(s, index, i)) {
                int cuts = 1 + minimumCut(s, i + 1, dp);
                ans = Math.min(ans, cuts);
            }
        }
        dp[index] = ans;
        return ans;
    }

    // Function to find maximum cut for palindrome partitioning of s.
    static int maximumCut(char s[], int index, int[] dp) {
        if (index == s.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = index; i < s.length; i++) {
            if (isPalindrome(s, index, i)) {
                int cuts = 1 + maximumCut(s, i + 1, dp);
                ans = Math.max(ans, cuts);
            }
        }
        dp[index] = ans;
        return ans;
    }

    // Function to find total number of cuts for palindrome partitioning of s.
    static int totalCuts(char s[], int index, int[] dp) {
        if (index == s.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int totalCuts = 0;
        for (int i = index; i < s.length; i++) {
            if (isPalindrome(s, index, i)) {
                totalCuts += 1 + totalCuts(s, i + 1, dp);
            }
        }
        dp[index] = totalCuts;
        return totalCuts;
    }

    // Main function
    public static void main(String args[]) {
        String s = "abaaab";
        int n = s.length();
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];
        int[] dpTotal = new int[n];
        Arrays.fill(dpMin, -1);
        Arrays.fill(dpMax, -1);
        Arrays.fill(dpTotal, -1);

        int minCuts = minimumCut(s.toCharArray(), 0, dpMin);
        int maxCuts = maximumCut(s.toCharArray(), 0, dpMax);
        int totalCuts = totalCuts(s.toCharArray(), 0, dpTotal);

        System.out.println("Minimum cuts to partition " + s + " is " + minCuts);
        System.out.println("Maximum cuts to partition " + s + " is " + maxCuts);
        System.out.println("Total cuts to partition " + s + " is " + totalCuts);

        s = "abccba";
        n = s.length();
        dpMin = new int[n];
        dpMax = new int[n];
        dpTotal = new int[n];
        Arrays.fill(dpMin, -1);
        Arrays.fill(dpMax, -1);
        Arrays.fill(dpTotal, -1);

        minCuts = minimumCut(s.toCharArray(), 0, dpMin);
        maxCuts = maximumCut(s.toCharArray(), 0, dpMax);
        totalCuts = totalCuts(s.toCharArray(), 0, dpTotal);

        System.out.println("Minimum cuts to partition " + s + " is " + minCuts);
        System.out.println("Maximum cuts to partition " + s + " is " + maxCuts);
        System.out.println("Total cuts to partition " + s + " is " + totalCuts);

        s = "abcda";
        n = s.length();
        dpMin = new int[n];
        dpMax = new int[n];
        dpTotal = new int[n];
        Arrays.fill(dpMin, -1);
        Arrays.fill(dpMax, -1);
        Arrays.fill(dpTotal, -1);

        minCuts = minimumCut(s.toCharArray(), 0, dpMin);
        maxCuts = maximumCut(s.toCharArray(), 0, dpMax);
        totalCuts = totalCuts(s.toCharArray(), 0, dpTotal);

        System.out.println("Minimum cuts to partition " + s + " is " + minCuts);
        System.out.println("Maximum cuts to partition " + s + " is " + maxCuts);
        System.out.println("Total cuts to partition " + s + " is " + totalCuts);
    }
}
