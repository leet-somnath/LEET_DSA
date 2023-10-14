/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        StringBuffer s1=new StringBuffer(s);
        s1.append(t);
       int xor=0;
       for(int i=0;i<s1.length();i++)
       {
           xor^=s1.charAt(i);
       }
       return (char)xor;

    }
}
// @lc code=end

