/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=allxor(n);
        int xor=0;
       for(int x:nums)
        xor^=x;
        return (xor^total);
    }
      public static int allxor(int r) {
        if (r % 4 == 0) {
            return r;
        } else if (r % 4 == 1) {
            return 1;
        } else if (r % 4 == 2) {
            return r + 1;
        } else if (r % 4 == 3) {
            return 0;
        }
        return 0;
    }
}
// @lc code=end

