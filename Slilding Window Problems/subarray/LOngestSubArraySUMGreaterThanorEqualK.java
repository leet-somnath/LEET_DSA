public class LOngestSubArraySUMGreaterThanorEqualK {

    public static int longestSubArraySum(int k, int[] nums) {
        int maxLength = 0;
        int sum = 0;
        int i = 0;
        int j = 0;
    
        while (j < nums.length) {
            sum += nums[j];
    
            // Shrink the window from the left until sum is >= k
            while (sum < k && i <= j) {
                j++;
                if(j<nums.length)
                    sum += nums[j];
            }
    
            // Update maxLength if the current subarray length is longer
            if (sum >= k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
    
            // Move left pointer to the right
            sum -= nums[i];
            i++;
        }
    
        return maxLength;
    }
    

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = longestSubArraySum(target, nums);
        System.out.println("maximal length of subarray with sum greater than or equal to " + target + " is: " + result); // Output: 2
    }
}
