
/*

1. Maximum Sum Subarray of Size K
2. Longest Substring Without Repeating Characters
3. Minimum Size Subarray Sum
4. Fruits into Baskets
5. Longest Repeating Character Replacement
6. Find All Anagrams in a String
7. Permutation in String
8. Longest Substring with At Most K Distinct Characters
9. Find K-Length Substrings With No Repeated Characters
10. Max Consecutive Ones
11. Number of Subarrays with Bounded Maximum
12. Shortest Word Distance III
13. Grumpy Bookstore Owner
14. Find All Duplicates in an Array
15. Max Consecutive Ones II
16. Minimum Swaps to Group All 1's Together
17. Longest Turbulent Subarray
18. Minimum Operations to Reduce X to Zero
19. Longest Substring with At Least K Repeating Characters
20. Minimum Size Subarray Sum II
21. Longest Substring with At Most Two Distinct Characters
22. Maximum Points You Can Obtain from Cards
23. Longest Mountain in Array
24. Minimum Deletions to Make Character Frequencies Unique
25. Maximize Number of Ones After Removing Consecutive Zeros
26. Minimum Operations to Make Array Increasing
27. Number of Substrings Containing All Three Characters
28. Maximize the Confusion of an Exam
29. Find All Anagrams in a String II
30. (Problem 30)

*/
import java.util.*;

public class SlidingWindowProblems {

    // Problem 1: Maximum Sum Subarray of Size K
    public static int maxSumSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;

        for (int i = 0, j = 0; j < n; j++) {
            windowSum += nums[j];
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[i];
                i++;
            }
        }

        return maxSum;
    }

    // Problem 2: Longest Substring Without Repeating Characters
    public static int longestSubstringWithoutRepeatingChars(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            char currentChar = s.charAt(j);
            if (charIndexMap.containsKey(currentChar)) {
                i = Math.max(charIndexMap.get(currentChar) + 1, i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            charIndexMap.put(currentChar, j);
        }

        return maxLength;
    }

    // Problem 3: Minimum Size Subarray Sum
    public static int minSizeSubarraySum(int[] nums, int target) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            windowSum += nums[j];
            while (windowSum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                windowSum -= nums[i];
                i++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Problem 4: Fruits into Baskets
    public static int totalFruit(int[] tree) {
        int n = tree.length;
        int maxFruits = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            fruitCount.put(tree[j], fruitCount.getOrDefault(tree[j], 0) + 1);
            while (fruitCount.size() > 2) {
                fruitCount.put(tree[i], fruitCount.get(tree[i]) - 1);
                if (fruitCount.get(tree[i]) == 0) {
                    fruitCount.remove(tree[i]);
                }
                i++;
            }
            maxFruits = Math.max(maxFruits, j - i + 1);
        }

        return maxFruits;
    }

    // Problem 5: Longest Repeating Character Replacement
    public static int longestRepeatingSubstringWithReplacement(String s, int k) {
        int n = s.length();
        int maxLength = 0;
        int maxCount = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            char currentChar = s.charAt(j);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
            maxCount = Math.max(maxCount, charCount.get(currentChar));

            if (j - i + 1 - maxCount > k) {
                char startChar = s.charAt(i);
                charCount.put(startChar, charCount.get(startChar) - 1);
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }

    // Problem 6: Find All Anagrams in a String
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length())
            return result;

        int[] charCount = new int[26];
        for (char c : p.toCharArray()) {
            charCount[c - 'a']++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (charCount[s.charAt(right++) - 'a']-- >= 1)
                count--;
            if (count == 0)
                result.add(left);
            if (right - left == p.length() && charCount[s.charAt(left++) - 'a']++ >= 0)
                count++;
        }

        return result;
    }

    // Problem 7: Permutation in String
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] charCount = new int[26];
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }

        int left = 0, right = 0, count = s1.length();
        while (right < s2.length()) {
            if (charCount[s2.charAt(right++) - 'a']-- >= 1)
                count--;
            if (count == 0)
                return true;
            if (right - left == s1.length() && charCount[s2.charAt(left++) - 'a']++ >= 0)
                count++;
        }

        return false;
    }

    // Problem 8: Longest Substring with At Most K Distinct Characters
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            charCount.put(s.charAt(j), j);
            if (charCount.size() > k) {
                int leftMost = Collections.min(charCount.values());
                charCount.remove(s.charAt(leftMost));
                i = leftMost + 1;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }

    // Problem 9: Find K-Length Substrings With No Repeated Characters
    public static List<String> findKLengthSubstringsWithNoRepeatedChars(String s, int k) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        for (int i = 0; i <= n - k; i++) {
            String substring = s.substring(i, i + k);
            if (noRepeatedCharacters(substring)) {
                result.add(substring);
            }
        }

        return result;
    }

    // Helper method for problem 9
    private static boolean noRepeatedCharacters(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    // Problem 11: Max Consecutive Ones
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    // Problem 12: Number of Subarrays with Bounded Maximum
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                start = i;
                end = i;
            } else if (nums[i] >= left) {
                end = i;
            }
            count += end - start;
        }
        return count;
    }

    // Problem 13: Shortest Word Distance III
    public static int shortestWordDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    index1 = index2;
                    index2 = i;
                } else {
                    index1 = i;
                }
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }
        return minDistance;
    }

    // Problem 14: Grumpy Bookstore Owner
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int satisfied = 0;
        int maxIncrease = 0;
        int increase = 0;
        for (int i = 0, j = 0; j < n; j++) {
            satisfied += grumpy[j] == 0 ? customers[j] : 0;
            increase += grumpy[j] == 1 ? customers[j] : 0;
            if (j - i + 1 > X) {
                increase -= grumpy[i] == 1 ? customers[i] : 0;
                i++;
            }
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return satisfied + maxIncrease;
    }

    // Problem 15: Find All Duplicates in an Array
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return result;
    }

    // Problem 16: Max Consecutive Ones II
    public static int findMaxConsecutiveOnesII(int[] nums) {
        int maxCount = 0;
        int count = 0;
        int left = 0;
        int zeroCount = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            count = right - left + 1;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    // Problem 17: Minimum Swaps to Group All 1's Together
    public static int minSwaps(int[] data) {
        int ones = 0;
        for (int d : data) {
            ones += d;
        }
        int countOnes = 0;
        for (int i = 0; i < ones; i++) {
            if (data[i] == 1) {
                countOnes++;
            }
        }
        int minSwaps = ones - countOnes;
        for (int i = ones; i < data.length; i++) {
            if (data[i] == 1) {
                countOnes++;
            }
            if (data[i - ones] == 1) {
                countOnes--;
            }
            minSwaps = Math.min(minSwaps, ones - countOnes);
        }
        return minSwaps;
    }

    // Problem 18: Longest Turbulent Subarray
    public static int maxTurbulenceSize(int[] arr) {
        int maxLength = 1;
        int increasing = 1;
        int decreasing = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                increasing = decreasing + 1;
                decreasing = 1;
            } else if (arr[i] < arr[i - 1]) {
                decreasing = increasing + 1;
                increasing = 1;
            } else {
                increasing = 1;
                decreasing = 1;
            }
            maxLength = Math.max(maxLength, Math.max(increasing, decreasing));
        }
        return maxLength;
    }

    // Problem 19: Minimum Operations to Reduce X to Zero
    public static int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        if (target == 0)
            return nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                maxLen = Math.max(maxLen, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }

    // Problem 20: Longest Substring with At Least K Repeating Characters
    public static int longestSubstring(String s, int k) {
        int maxLength = 0;
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            maxLength = Math.max(maxLength, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));
        }
        return maxLength;
    }

    private static int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] charCount = new int[26];
        int numUnique = 0;
        int numNoLessThanK = 0;
        int start = 0;
        int end = 0;
        int maxLength = 0;
        while (end < s.length()) {
            if (charCount[s.charAt(end) - 'a'] == 0)
                numUnique++;
            if (charCount[s.charAt(end) - 'a'] == k - 1)
                numNoLessThanK++;
            charCount[s.charAt(end) - 'a']++;
            end++;
            while (numUnique > numUniqueTarget) {
                if (charCount[s.charAt(start) - 'a'] == k)
                    numNoLessThanK--;
                if (charCount[s.charAt(start) - 'a'] == 1)
                    numUnique--;
                charCount[s.charAt(start) - 'a']--;
                start++;
            }
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
                maxLength = Math.max(maxLength, end - start);
            }
        }
        return maxLength;
    }

    // Problem 21: Minimum Size Subarray Sum II
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            windowSum += nums[j];
            while (windowSum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                windowSum -= nums[i];
                i++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Problem 22: Longest Substring with At Most Two Distinct Characters
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            charCount.put(s.charAt(j), j);
            if (charCount.size() > 2) {
                int leftMost = Collections.min(charCount.values());
                charCount.remove(s.charAt(leftMost));
                i = leftMost + 1;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }

    // Problem 23: Maximum Points You Can Obtain from Cards
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = Arrays.stream(cardPoints).sum();
        int windowSum = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n - k; i++) {
            windowSum += cardPoints[i];
        }
        minSum = Math.min(minSum, windowSum);

        for (int i = n - k; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - (n - k)];
            minSum = Math.min(minSum, windowSum);
        }

        return totalSum - minSum;
    }

    // Problem 24: Longest Mountain in Array
    public static int longestMountain(int[] arr) {
        int maxLength = 0;
        int n = arr.length;
        int i = 0;

        while (i < n) {
            int base = i;
            while (i + 1 < n && arr[i] < arr[i + 1]) {
                i++;
            }

            if (i == base) {
                i++;
                continue;
            }

            int peak = i;
            while (i + 1 < n && arr[i] > arr[i + 1]) {
                i++;
            }

            if (i == peak) {
                i++;
                continue;
            }

            int length = i - base + 1;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    // Problem 25: Minimum Deletions to Make Character Frequencies Unique
    public static int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Set<Integer> usedFreq = new HashSet<>();
        int deletions = 0;

        for (int f : freq) {
            while (f > 0 && !usedFreq.add(f)) {
                f--;
                deletions++;
            }
        }

        return deletions;
    }

    // Problem 26: Maximize Number of Ones After Removing Consecutive Zeros
    public static int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int zeroCount = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // Problem 27: Minimum Operations to Make Array Increasing
    public static int minOperations(int[] nums) {
        int operations = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                operations += prev - nums[i] + 1;
                prev++;
            } else {
                prev = nums[i];
            }
        }
        return operations;
    }

    // Problem 28: Number of Substrings Containing All Three Characters
    public static int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !(count[0] > 0 && count[1] > 0 && count[2] > 0)) {
                count[s.charAt(j++) - 'a']++;
            }
            if (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += s.length() - j + 1;
            }
            count[s.charAt(i) - 'a']--;
        }
        return result;
    }

    // Problem 29: Maximize the Confusion of an Exam
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int maxScore = 0;
        int n = answerKey.length();
        int left = 0;
        int maxCount = 0;
        int[] count = new int[2];

        for (int right = 0; right < n; right++) {
            count[answerKey.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, Math.max(count[0], count[1]));
            while (right - left + 1 - maxCount > k) {
                count[answerKey.charAt(left) - 'A']--;
                left++;
            }
            maxScore = Math.max(maxScore, right - left + 1);
        }

        return maxScore;
    }



    public static void main(String[] args) {
        // Test each problem here
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println("Problem 1: Maximum sum of subarray of size " + k + ": " + maxSumSubarray(nums, k));

        String str = "abcabcbb";
        System.out.println("Problem 2: Longest substring without repeating characters: "
                + longestSubstringWithoutRepeatingChars(str));

        int[] nums2 = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println(
                "Problem 3: Minimum size subarray sum for target " + target + ": " + minSizeSubarraySum(nums2, target));

        int[] tree = { 1, 2, 1, 3, 4, 3, 5, 1, 2 };
        System.out.println("Problem 4: Maximum number of fruits in two baskets: " + totalFruit(tree));

        String str2 = "AABABBA";
        int replacements = 1;
        System.out.println("Problem 5: Longest repeating substring with replacement: "
                + longestRepeatingSubstringWithReplacement(str2, replacements));

        String s = "cbaebabacd";
        String p = "abc";
        System.out.println("Problem 6: Anagrams start indices in string: " + findAnagrams(s, p));

        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("Problem 7: Does s2 contain permutation of s1? " + checkInclusion(s1, s2));

        String s3 = "eceba";
        int k2 = 2;
        System.out.println("Problem 8: Length of longest substring with at most " + k2 + " distinct characters: "
                + lengthOfLongestSubstringKDistinct(s3, k2));

        String s4 = "awaglknagawunagwkwagl";
        int k3 = 4;
        System.out.println("Problem 9: K-length substrings with no repeated characters: "
                + findKLengthSubstringsWithNoRepeatedChars(s4, k3));
    }
}
