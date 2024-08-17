/*
 * given an array nums of n integers where nums[i] is in the range [1, n],
 *  return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         List<Integer> missingNumbers = new ArrayList<>();

        // Create a HashSet to store the numbers that appear in the array
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

      
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                missingNumbers.add(i);
            }
        }

        return missingNumbers;
    }

   
    }

