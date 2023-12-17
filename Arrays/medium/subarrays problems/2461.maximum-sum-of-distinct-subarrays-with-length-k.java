/*
 * @lc app=leetcode id=2461 lang=java
 *
 * [2461] Maximum Sum of Distinct Subarrays With Length K
 */

// @lc code=start
import java.io.*;
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
      long sum = 0, ans = 0;
        int i = 0, j = 0;
        Set<Integer> x = new HashSet<>();

        while (j < nums.length) {
            while (x.contains(nums[j])) {
                x.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            sum += nums[j];
            x.add(nums[j]);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                ans = Math.max(ans, sum);
                x.remove(nums[i]);
                sum -= nums[i];
                i++;
                j++;
            }
        }

        return ans;
    }
}
// @lc code=end

