/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++; // Move to the next character in s
            }
            tPointer++; // Move to the next character in t
        }

        // If all characters in s are found in t in the same order
        return sPointer == s.length();
    }
}

// @lc code=end

