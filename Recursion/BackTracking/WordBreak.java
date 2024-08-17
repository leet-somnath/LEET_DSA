import java.util.*;

class wordBreak {
    public static boolean f(String str, Set<String> s, int i) {
        // base case
        if (i == str.length()) {
            return true;
        }
        // recursive case
        boolean ans = false;
        StringBuilder temp = new StringBuilder();
        for (int j = i; j < str.length(); j++) {
            temp.append(str.charAt(j));
            if (s.contains(temp.toString())) {
                ans = f(str, s, j + 1);
                if (ans) {
                    break;
                }
            }
        }
        return ans;
    }



    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> ss = new HashSet<>(wordDict);
        // return f(s, ss, 0);
        return f(s, ss,0);
    }
}
