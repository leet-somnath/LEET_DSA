/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
      int temp[]=new int[k];
      int n=nums.length;
      for(int i=n-k;i<n;i++)
      temp[k++]=nums[i];
      for(int i=0;i<n-k;i++)
      temp[k++]=nums[i];
      for(int i=0;i<n;i++)
      nums[i]=temp[i];
    }
}
// @lc code=end

