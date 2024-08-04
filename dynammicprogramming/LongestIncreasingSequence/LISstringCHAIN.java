import java.util.*;

class LISstringCHAIN {
    // Function to compare two strings and check if they form a valid chain
    private static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }

    // Memoization function to find the longest string chain
    private static int longestStrChain(List<String> arr, int index, int[] dp) {
        if (dp[index] != -1) {
            return dp[index];
        }

        int maxLength = 1;

        for (int prevIndex = 0; prevIndex < index; prevIndex++) {
            if (compare(arr.get(index), arr.get(prevIndex))) {
                int currentLength = 1 + longestStrChain(arr, prevIndex, dp);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        dp[index] = maxLength;
        return dp[index];
    }

    public static int longestStrChain(String[] words) {
        List<String> wordList = Arrays.asList(words);

        // Sort the array by string length
        wordList.sort(Comparator.comparingInt(String::length));

        int n = wordList.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, longestStrChain(wordList, i, dp));
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println("The length of the longest string chain is: " +longestStrChain(words));
    }
}
