/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start

   class Solution {
   public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }else if(nums[mid]<nums[low]){
                high=mid;
                low++;
            }
            else
            high--;
            }
        
        return nums[low];

    }

}
// @lc code=end

