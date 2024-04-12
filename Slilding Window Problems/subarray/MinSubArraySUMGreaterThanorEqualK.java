
/* 
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 
*/
public class MinSubArraySUMGreaterThanorEqualK {

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, ans = Integer.MAX_VALUE;
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
                ans = Math.min(ans, j - i + 1);
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
        int result = minSubArrayLen(target, nums);
        System.out.println("Minimal length of subarray with sum greater than or equal to " + target + " is: " + result); // Output: 2
    }
}
