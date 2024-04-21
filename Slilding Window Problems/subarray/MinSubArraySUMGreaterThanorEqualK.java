
/* 
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 
*/
public class MinSubArraySUMGreaterThanorEqualK {

    public static int minSubArraySum(int k, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
    
        while (j < nums.length) {
            sum += nums[j];
    
            // Shrink the window from the left until sum is >= k
            while (sum < k && i <= j) {
                j++;
                if (j < nums.length) {
                    sum += nums[j];
                }
            }
    
            // Update minLength if the current subarray length is shorter
            while (sum >= k && i <= j) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i];
                i++;
            }
    
            j++;
        }
    
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = minSubArraySum(target, nums);
        System.out.println("Minimal length of subarray with sum greater than or equal to " + target + " is: " + result); // Output: 2
    }
}
