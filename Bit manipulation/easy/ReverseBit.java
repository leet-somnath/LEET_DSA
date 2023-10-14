/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int A) {
        int rev=0;
       for (int i = 0; i < 32; i++)
  {
    rev<<=1;
    rev|= (A & 1);
    A = A >> 1;
  }
        return rev;
    }
}
// @lc code=end

