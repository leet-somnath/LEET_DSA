public static int longestSubArraySum(int k, int[] nums) {
    int maxLength = 0;
    int sum = 0;
    int i = 0;
    int j = 0;

    while (j < nums.length) {
        sum += nums[j];

        // Shrink the window from the left until sum is <= k
        while (sum > k && i <= j) {
            sum -= nums[i];
            i++;
        }

        // Update maxLength if the current subarray length is longer
        if (sum <= k) {
            maxLength = Math.max(maxLength, j - i + 1);
        }

        j++;
    }

    return maxLength;
}

//no of subarrays with sum strictly less than k

/*
 * public static int countSubArraySumLessThanK(int target, int[] nums) {
    int count = 0;
    int sum = 0;
    int i = 0;
    int j = 0;

    while (j < nums.length) {
        sum += nums[j];

        // Shrink the window from the left until sum is >= target
        while (sum >= target && i <= j) {
            sum -= nums[i];
            i++;
        }

        // Count subarrays where the sum is less than target
        count += (j - i + 1);

        j++;
    }

    return count;
}

 */