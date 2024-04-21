public static int countSubArraySum(int target, int[] nums) {
    int count = 0;
    int sum = 0;
    int i = 0;
    int j = 0;

    while (j < nums.length) {
        sum += nums[j];

        // If the current sum exceeds the target, move the left pointer (i) to the right
        while (sum > target && i <= j) {
            sum -= nums[i];
            i++;
        }

        // If the current sum equals the target, count the subarrays
        if (sum == target) {
            count++;
        }

        j++;
    }

    return count;
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