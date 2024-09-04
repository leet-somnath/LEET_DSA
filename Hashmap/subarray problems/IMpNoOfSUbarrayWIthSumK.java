import java.util.HashMap;

class IMpNoOfSUbarrayWithSumK {
    public int numSubarraysWithSum(int[] nums, int target) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();

        // Base case: There's one way to get a sum of 0 (by having no elements)
        prefixSumFreq.put(0, 1);

        for (int num : nums) {
            sum += num;

            // If (sum - target) exists in the map, it means there is a subarray that sums to target
            count += prefixSumFreq.getOrDefault(sum - target, 0);

            // Add the current sum to the map
            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
