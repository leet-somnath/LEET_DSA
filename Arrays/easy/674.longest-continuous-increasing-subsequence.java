/*
 * @lc app=leetcode id=674 lang=java
 *
 * [674] Longest Continuous Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] arr) {
        int c=1,ans=1;
        for (int i = 0; i < arr.length-1; i++) {
            
            if(arr[i]<arr[i+1])
            {
                c++;
            ans=Math.max(ans, c);}
            else
            {
                c=1;
            }
        }
        return ans;
    }
}
// @lc code=end

