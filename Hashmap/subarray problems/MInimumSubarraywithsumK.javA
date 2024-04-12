import java.util.HashMap;
import java.util.Map;

public class MInimumSubarraywithsumK {
    public static int minSubArrayLen(int k, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        Map<Integer, Integer> sumIndices = new HashMap<>();
        sumIndices.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumIndices.containsKey(sum - k)) {
              
                minLength = Math.min(minLength, i - sumIndices.get(sum - k));
            }
            if (!sumIndices.containsKey(sum)) {
                sumIndices.put(sum, i);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int k = 7;
        int minLength = minSubArrayLen(k, nums);
        System.out.println("Minimum length of subarray with sum " + k + " is: " + minLength); // Output: 2
    }
}
