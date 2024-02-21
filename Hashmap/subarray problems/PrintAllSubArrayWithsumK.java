import java.util.*;

public class PrintAllSubArrayWithsumK {

    public static void subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, new ArrayList<>(Arrays.asList(-1))); // To handle the case when the subarray with sum k starts from index 0
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixSumMap.containsKey(sum - k)) {
                List<Integer> indices = prefixSumMap.get(sum - k);
                for (int index : indices) {
                    System.out.println("Subarray with sum " + k + ": " + (index + 1) + " to " + i);
                }
            }
            prefixSumMap.putIfAbsent(sum, new ArrayList<>());
            prefixSumMap.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        subarraySum(nums, k);
    }
}
