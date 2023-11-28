/*
 * @lc app=leetcode id=747 lang=java
 *
 * [747] Largest Number At Least Twice of Others
 */

// @lc code=start
import java.util.*;
class Solution {
  public int dominantIndex(int[] nums) {
    int maxIndex = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > nums[maxIndex]) {
            maxIndex = i;
        }
    }
    for (int i = 0; i < nums.length; i++) {
        if (i != maxIndex && nums[i] * 2 > nums[maxIndex]) {
            return -1;
        }
    }
    return maxIndex;
}
    
}
// @lc code=end

