/*
 * Given a string s, find the first non-repeating character in 
 * it and return its index. If it does not exist, return -1.


Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] oc = new int[26]; // array to store frequency of each character

        // store frequency of each character of s
        for (char c : s.toCharArray()) {
            oc[c - 'a']++;
        }

        // find the first character with frequency = 1
        for (int i = 0; i < s.length(); i++) {
            if (oc[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // no character with frequency = 1
        return -1;
    }
}