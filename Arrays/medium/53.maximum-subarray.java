/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int maxindex=nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxindex=Math.max(maxindex+nums[i-1],nums[i]);
            result=Math.max(maxindex,result);
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