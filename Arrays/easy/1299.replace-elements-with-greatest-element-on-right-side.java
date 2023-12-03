/*
 * @lc app=leetcode id=1299 lang=java
 *
 * [1299] Replace Elements with Greatest Element on Right Side
 */

// @lc code=start
class Solution {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = findMax(arr, i + 1);
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public static int findMax(int[] nums, int k) {

        int max = nums[k];

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
}

// @lc code=end
