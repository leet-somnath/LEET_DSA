/*Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1. */

import java.util.*;
import java.io.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(longest(str));
        sc.close();
    }

    static int longest(String str) {
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (j < str.length()) {
            char currentChar = str.charAt(j);
            if (map.containsKey(currentChar)) {

                i = Math.max(map.get(currentChar) + 1, i);
            }
            maxlen = Math.max(j - i + 1, maxlen);
            map.put(currentChar, j);
            j++;

        }
        return maxlen;
    }

}