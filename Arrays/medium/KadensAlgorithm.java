/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum < 0)
                sum = 0;
        }
        return result;
    }
}
// @lc code=end

/*
 * for(int i = 0; i < nums.length; i++) {
 * int sum = 0;
 * for(int j = i; j <nums.length; j++)
 * { sum += nums[j];
 * if(sum > max) {
 * max = sum; } } }
 * return max;
 */