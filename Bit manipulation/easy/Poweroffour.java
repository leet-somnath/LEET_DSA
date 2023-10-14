/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int n) {
          double sqrt = Math.sqrt(n);
          if(n==0)
          return false;

        if(sqrt==(int)sqrt)
        {
            if((n&(n-1))==0)
            {

                return true;
            }
        }
        
            return false;
        
    }
}
// @lc code=end

