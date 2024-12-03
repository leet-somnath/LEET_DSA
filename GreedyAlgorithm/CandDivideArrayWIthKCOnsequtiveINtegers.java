import java.util.*;

public class DivideArrayIntoKConsecutiveIntegers {

    public static boolean canDivideIntoConsecutiveGroups(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false; // Cannot divide into groups of size k
        }

        // Count frequency of each number using TreeMap for automatic sorting
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Process each key in the sorted order
        for (int num : freqMap.keySet()) {
            while (freqMap.get(num) > 0) {
                // Form a group starting from this number
                for (int i = 0; i < k; i++) {
                    int currentNum = num + i;
                    if (freqMap.getOrDefault(currentNum, 0) <= 0) {
                        return false; // Cannot form a valid group
                    }
                    freqMap.put(currentNum, freqMap.get(currentNum) - 1); // Reduce frequency
                }
            }
        }

        return true; // Successfully divided into groups
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 4, 4, 5, 6};
        int k1 = 4;
        System.out.println(canDivideIntoConsecutiveGroups(nums1, k1)); // Output: true

        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 3;
        System.out.println(canDivideIntoConsecutiveGroups(nums2, k2)); // Output: false
    }
}
