public class CountallPalindromicSubsequence {

    // Recursive utility function to count palindromic subsequences
    // in the substring s[i..j] using memoization
    static int countPSUtil(String s, int i, int j, int[][] memo) {
      
        // Base case: if the starting index exceeds the ending index
        if (i > j)
            return 0;

        // Base case: if there is only one character
        if (i == j)
            return 1;

        // Return the already computed subproblem if it exists
        if (memo[i][j] != -1)
            return memo[i][j];

        if (s.charAt(i) == s.charAt(j)) {
          
            // Count palindromes by including both characters
            memo[i][j] = 1 + countPSUtil(s, i + 1, j, memo) +
                         countPSUtil(s, i, j - 1, memo);
        } else {
          
            // If characters are different, count palindromes
            memo[i][j] = countPSUtil(s, i + 1, j, memo) +
                         countPSUtil(s, i, j - 1, memo) -
                         countPSUtil(s, i + 1, j - 1, memo);
        }

        // Return the computed result for the substring s[i..j]
        return memo[i][j];
    }

    // Function to count the number of palindromic subsequences
    // in a given string
    static int countPS(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];

        // Initialize memoization table to -1
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                memo[i][j] = -1;

        return countPSUtil(s, 0, n - 1, memo);
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks"; 
        System.out.println(countPS(s)); 
    }
}
