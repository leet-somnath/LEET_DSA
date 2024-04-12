public class MaxSubArraySUMGreaterThanorEqualK {

    public static int maxSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, ans = Integer.MIN_VALUE;
        long sum = 0;

        while (j < nums.length) {
            sum += nums[j];
            if (sum >= target) {
                while (sum >= target) {
                    sum -= nums[i];
                    i++;
                }
                i--; // Backtrack one step
                sum += nums[i];
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }

        if (ans == Integer.MAX_VALUE) {
            return 0;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = maxSubArrayLen(target, nums);
        System.out.println("maximal length of subarray with sum greater than or equal to " + target + " is: " + result); // Output: 2
    }
}
