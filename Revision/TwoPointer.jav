import java.util.*;

public class TwoPointerProblems {

    // 1. Check if array has a pair with given sum (Sorted Array)
    public static boolean hasPairWithSum(int[] arr, int sum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currSum = arr[left] + arr[right];
            if (currSum == sum) return true;
            if (currSum < sum) left++;
            else right--;
        }
        return false;
    }

    // 2. Remove duplicates from sorted array
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    
    // 3. Merge two sorted arrays without extra space
    public static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = 0;
        while (i >= 0 && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--; j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    
    // 4. Move all zeroes to end
    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
    
    // 5. Reverse a string in place
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    
    // 6. Check if a palindrome
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // 7. Square of a sorted array
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1, index = n - 1;
        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq > rightSq) {
                result[index--] = leftSq;
                left++;
            } else {
                result[index--] = rightSq;
                right--;
            }
        }
        return result;
    }

    // 8. Find the closest sum to target (Three sum closest)
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum < target) left++;
                else right--;
            }
        }
        return closestSum;
    }

    // 9. Find two elements whose sum is closest to zero
    public static int[] closestToZero(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                result[0] = nums[left];
                result[1] = nums[right];
            }
            if (sum < 0) left++;
            else right--;
        }
        return result;
    }

    // 10. Find longest substring with at most k distinct characters
    public static int longestSubstringKDistinct(String s, int k) {
        int left = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
      // 11. Find the maximum water trapped (Container with Most Water)
      public static int maxWater(int[] height) {
        int left = 0, right = height.length - 1, maxWater = 0;
        while (left < right) {
            maxWater = Math.max(maxWater, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxWater;
    }
    
    // 12. Find the intersection of two sorted arrays
    public static List<Integer> intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                result.add(nums1[i]);
                i++; j++;
            }
        }
        return result;
    }
    
    // 13. Find the shortest subarray with sum greater than or equal to target
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    // 14. Check if a string is a valid palindrome ignoring non-alphanumeric characters
    public static boolean isValidPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++; right--;
        }
        return true;
    }
    
    // 15. Find the K-th smallest pair distance
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2, count = 0, j = 0;
            for (int i = 0; i < nums.length; i++) {
                while (j < nums.length && nums[j] - nums[i] <= mid) j++;
                count += j - i - 1;
            }
            if (count >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    // 16. Count number of pairs with absolute difference less than K
    public static int countPairsWithDifferenceLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] >= k) left++;
            count += right - left;
        }
        return count;
    }
    
    // 17. Check if two strings are almost equal (at most k modifications)
    public static boolean areAlmostEqual(String s1, String s2, int k) {
        if (s1.length() != s2.length()) return false;
        int left = 0, right = s1.length() - 1, changes = 0;
        while (left < right) {
            if (s1.charAt(left) != s2.charAt(left)) changes++;
            if (s1.charAt(right) != s2.charAt(right)) changes++;
            left++; right--;
        }
        return changes <= k;
    }
    
    // 18. Find the maximum sum of k-length subarray
    public static int maxSumSubarray(int[] nums, int k) {
        int left = 0, sum = 0, maxSum = Integer.MIN_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (right >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[left++];
            }
        }
        return maxSum;
    }
    
    // 19. Find the smallest window in a string containing all characters of another string
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0, minLen = Integer.MAX_VALUE, count = 0, start = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) count++;
            }
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left++);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) count--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
    
    // 20. Find the minimum absolute difference pair
    public static int minAbsDifference(int[] nums) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i] - nums[i - 1]);
        }
        return minDiff;
    }
        // 21. Find triplets with a given sum
        public static List<List<Integer>> threeSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++; right--;
                    } else if (sum < target) left++;
                    else right--;
                }
            }
            return result;
        }
    
        // 22. Find the longest mountain in an array
        public static int longestMountain(int[] arr) {
            int maxLen = 0, n = arr.length;
            for (int i = 1; i < n - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    int left = i, right = i;
                    while (left > 0 && arr[left] > arr[left - 1]) left--;
                    while (right < n - 1 && arr[right] > arr[right + 1]) right++;
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
            return maxLen;
        }
    
        // 23. Find all unique quadruplets with a given sum
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int left = j + 1, right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) left++;
                            while (left < right && nums[right] == nums[right - 1]) right--;
                            left++; right--;
                        } else if (sum < target) left++;
                        else right--;
                    }
                }
            }
            return result;
        }
    
        // 24. Find the smallest subarray with sum greater than k
        public static int minSubArrayLen(int k, int[] nums) {
            int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum > k) {
                    minLen = Math.min(minLen, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    
        // 25. Merge two sorted arrays in-place
        public static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1, k = m + n - 1;
            while (i >= 0 && j >= 0) {
                nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            }
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    
        // 26. Find max consecutive ones with one zero flip
        public static int maxConsecutiveOnes(int[] nums) {
            int left = 0, maxLen = 0, zeroCount = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == 0) zeroCount++;
                while (zeroCount > 1) {
                    if (nums[left] == 0) zeroCount--;
                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }
            return maxLen;
        }
    
        // 27. Find the max length of a subarray with sum equals k
        public static int maxSubArrayLen(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0, maxLen = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) maxLen = i + 1;
                if (map.containsKey(sum - k)) maxLen = Math.max(maxLen, i - map.get(sum - k));
                map.putIfAbsent(sum, i);
            }
            return maxLen;
        
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Has pair with sum 9: " + hasPairWithSum(arr, 9));
        
        int[] nums = {1, 1, 2, 2, 3};
        System.out.println("New length after removing duplicates: " + removeDuplicates(nums));
        
        int[] closestArr = {-10, -3, 1, 2, 4, 8};
        System.out.println("Pair closest to zero: " + Arrays.toString(closestToZero(closestArr)));
        
        System.out.println("Longest substring with 2 distinct characters: " + longestSubstringKDistinct("eceba", 2));
    }
}
