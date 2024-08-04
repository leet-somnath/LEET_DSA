import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
          int n = nums.length;
        Arrays.sort(nums); // Sort the array to ensure the divisibility condition

        List<Integer>[] dp = new List[n];
        int maxSize = 0;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j].size() + 1 > dp[i].size()) {
                    dp[i] = new ArrayList<>(dp[j]);
                    dp[i].add(nums[i]);
                }
            }
            if (dp[i].size() > maxSize) {
                maxSize = dp[i].size();
                maxIndex = i;
            }
        }

        return dp[maxIndex];
    }
}