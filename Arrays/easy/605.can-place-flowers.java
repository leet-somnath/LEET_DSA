/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int len = arr.length;
        
        if (len > 1) {

            if (arr[0] == 0 && arr[1] == 0) {
                arr[0] = 1;
                n--;
            }
            for (int i = 1; i < len - 1; i++) {
                int sum = 0;
                if (arr[i] == 0) {
                    sum = arr[i - 1] + arr[i + 1];
                    if (sum == 0) {
                        arr[i] = 1;
                        n--;
                    }
                }
            }
            if (arr[len - 2] == 0 && arr[len - 1] == 0) {
                n--;
            }
        }
        else
        {
            if(arr[0]==0)
            n--;
        }
        return n <= 0;
    }
}
// @lc code=end
