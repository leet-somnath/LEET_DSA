import java.util.*;

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.fill(ans, -1); // initialize answer array with -1

        Arrays.sort(nums); // sort nums in ascending order
        
        for (int i = 0; i < q; i++) {
            int x = queries[i][0];
            int m = queries[i][1];

            // if the minimum element in nums is greater than m, skip this query
            if (m < nums[0]) continue;

            int end = upperBound(nums, m); // index after the last element <= m
            int start = 0;
            int k = 0, cur = 0;

            for (int bit = 31; bit >= 0; bit--) {
                if ((x & (1 << bit)) != 0) { // hope nums[i] has this bit == 0
                    if ((nums[start] & (1 << bit)) == 0) {
                        k |= 1 << bit;
                        end = lowerBound(nums, start, end, cur | (1 << bit));
                    } else {
                        cur |= 1 << bit;
                    }
                } else { // hope nums[i] has this bit == 1
                    if (start <= end - 1 && (nums[end - 1] & (1 << bit)) != 0) {
                        k |= 1 << bit;
                        cur |= 1 << bit;
                        start = lowerBound(nums, start, end, cur);
                    }
                }
            }
            ans[i] = k;
        }
        return ans;
    }

    // Helper method to find the first index with value greater than target
    private int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    // Helper method to find the first index with value greater than or equal to target within a range
    private int lowerBound(int[] nums, int start, int end, int target) {
        int low = start, high = end;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
