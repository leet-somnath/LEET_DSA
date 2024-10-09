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
