import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    // Pair class to store length and count together
    static class Pair {
        int length;
        int count;

        Pair(int length, int count) {
            this.length = length;
            this.count = count;
        }
    }

    public Pair solveMem(int[] nums, int curr, int prev, Pair[][] dp) {
        if (curr == nums.length) {
            return new Pair(0, 1);
        }

        if (dp[curr][prev + 1].length != -1) {
            return dp[curr][prev + 1];
        }

        int length = 0, count = 0;

        if (prev == -1 || nums[prev] < nums[curr]) {
            Pair include = solveMem(nums, curr + 1, curr, dp);
            int includeLength = 1 + include.length;
            if (includeLength > length) {
                length = includeLength;
                count = include.count;
            } else if (includeLength == length) {
                count += include.count;
            }
        }

        Pair exclude = solveMem(nums, curr + 1, prev, dp);
        if (exclude.length > length) {
            length = exclude.length;
            count = exclude.count;
        } else if (exclude.length == length) {
            count += exclude.count;
        }

        dp[curr][prev + 1] = new Pair(length, count);

        return dp[curr][prev + 1];
    }

    public int findNumberOfLIS(int[] nums) {
        int curr = 0, prev = -1;
        Pair[][] dp = new Pair[nums.length][nums.length + 1];

        // Initialize dp array with pairs of (-1, -1)
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length + 1; j++) {
                dp[i][j] = new Pair(-1, -1);
            }
        }

        Pair result = solveMem(nums, curr, prev, dp);
        return result.count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("The total number of longest increasing subsequences is " + sol.findNumberOfLIS(nums));
    }
}
