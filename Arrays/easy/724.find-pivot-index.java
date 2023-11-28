/*
 * @lc app=leetcode id=724 lang=java
 *
 * [724] Find Pivot Index
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
       int pivot[]=new int[nums.length];
       int sum=0,flag=-1;
        for (int i = 0; i < nums.length; i++) {
        pivot[i]=sum;
        sum+=nums[i];
       }
       sum=0;
       for(int i=nums.length-1;i>=0;i--){
        if(pivot[i]==sum){
             flag=i;
        }
        sum+=nums[i];
       }
       return flag;
    }
}
// @lc code=end
