public class MinimumMountainSum {
    public static int minimumMountainSum(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE; // Initialize minSum to a large value

        for (int i = 1; i < n - 1; i++) {
            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && right < n) {
                if (nums[left] < nums[i] && nums[right] < nums[i]) {
                    int sum = nums[left] + nums[i] + nums[right];
                    minSum = Math.min(minSum, sum); // Update minSum if a valid mountain sum is found
                }
                left--;
                right++;
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum; // Return -1 if no valid mountain sum is found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        int result = minimumMountainSum(nums);
        System.out.println(result);  // Output: 4
    }
}
