/*

Given an integer array, check if it contains a contiguous subarray having zero-sum.

Input : [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]
Output: true
Explanation: The subarrays with zero-sum are

[3, 4, -7]
[4, -7, 3]
[-7, 3, 1, 3]
[3, 1, -4]
[3, 1, 3, 1, -4, -2, -2]
[3, 4, -7, 3, 1, 3, 1, -4, -2, -2]

Input : [4, -7, 1, -2, -1]
Output: false
Explanation: The subarray with zero-sum doesn't exist.

*/




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSubArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<List<Integer>> subarrays = findZeroSumSubarrays(nums);

        if (subarrays.isEmpty()) {
            System.out.println("No subarray with zero sum exists");
        } else {
            System.out.println("Subarrays with zero sum exist:");
            for (List<Integer> subarray : subarrays) {
                System.out.println(subarray);
            }
        }
    }

    public static List<List<Integer>> findZeroSumSubarrays(int[] nums) {
        List<List<Integer>> subarrays = new ArrayList<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;

        sumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sumMap.containsKey(sum)) {
                int startIndex = sumMap.get(sum) + 1;
                subarrays.add(getSubarray(nums, startIndex, i));
            }

            sumMap.put(sum, i);
        }

        return subarrays;
    }

    public static List<Integer> getSubarray(int[] nums, int start, int end) {
        List<Integer> subarray = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            subarray.add(nums[i]);
        }
        return subarray;
    }
}