/**
 * The DuplicateNplusOne class finds and returns
 *  the duplicate number in an array of integers.
 */

package Arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNplusOne {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        int duplicate = findDuplicate(nums);
        System.out.println("Duplicate number: " + duplicate);
    }

    public static int findDuplicate(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();

        for (int num : nums) {
            if (numCount.containsKey(num)) {
                return num;
            } else {
                numCount.put(num, 1);
            }
        }

        return -1;
    }
}