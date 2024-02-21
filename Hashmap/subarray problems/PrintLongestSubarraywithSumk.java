import java.util.HashMap;
import java.util.Map;

public class PrintLongestSubarraywithSumk {
    public static int[] longestSubarraySum(int[] nums, int k) {
        int maxLength = 0;
        int start = -1;
        int end = -1;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int complement = prefixSum - k;
            if (map.containsKey(complement)) {
                int length = i - map.get(complement);
                if (length > maxLength) {
                    maxLength = length;
                    start = map.get(complement) + 1;
                    end = i;
                }
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        System.out.println("maxlength is" + maxLength);

        if (start != -1 && end != -1) {
            int[] longestSubarray = new int[maxLength];
            for (int i = start; i <= end; i++) {
                longestSubarray[i - start] = nums[i];
            }
            return longestSubarray;
        } else {
            return new int[0]; // Return empty array if no subarray with sum equals k is found
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        int[] longestSubarray = longestSubarraySum(nums, k);
        System.out.println("Longest subarray with sum " + k + ":");
        for (int num : longestSubarray) {
            System.out.print(num + " ");
        }
    }
}
