import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> ss = new HashSet<>(wordDict);
        int n = s.length();
        Boolean[][] memo = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], null);
        }
        return f(s, ss, 0, memo);
    }

    public static boolean f(String str, Set<String> s, int i, Boolean[][] memo) {
        // base case
        if (i == str.length()) {
            return true;
        }
        // check memo
        if (memo[i][str.length() - 1] != null) {
            return memo[i][str.length() - 1];
        }
        // recursive case
        boolean ans = false;
        StringBuilder temp = new StringBuilder();
        for (int j = i; j < str.length(); j++) {
            temp.append(str.charAt(j));
            if (s.contains(temp.toString())) {
                ans = f(str, s, j + 1, memo);
                if (ans) {
                    break;
                }
            }
        }
        memo[i][str.length() - 1] = ans;
        return ans;
    }
}
