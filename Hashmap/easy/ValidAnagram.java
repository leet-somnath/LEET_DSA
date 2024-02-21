/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}
/*
 * using count array
 * 
 * 
 * class Solution {
        static final int charr=256;
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
        int count[]=new int[charr];
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;

        }
        for(int i:count)
        {
            if(i!=0)
            return false;
        }
        return true;
    }
}

 */