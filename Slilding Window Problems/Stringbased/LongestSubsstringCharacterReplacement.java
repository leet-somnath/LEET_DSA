
/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.*/
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int length = 0;
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            count[s.charAt(j) - 'A']++;
            max = Math.max(max, count[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
            length = Math.max(length, j - i + 1);
            j++;
        }
        return length;
    }
}
