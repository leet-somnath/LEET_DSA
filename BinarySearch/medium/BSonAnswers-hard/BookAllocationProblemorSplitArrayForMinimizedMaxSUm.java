class Solution {
    private boolean isPossible(int[] nums, int maxSum, int k) {
        int subarrays = 1, sum = 0;

        for (int num : nums) {
            if (sum + num > maxSum) {
                sum = num;
                subarrays++;

                if (subarrays > k)
                    return false;
            } else {
                sum += num;
            }
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {
        int low = nums[0], high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, k)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}