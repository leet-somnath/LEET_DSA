
//  https://leetcode.com/problems/find-common-elements-between-two-arrays/description/

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        // Initialize frequency arrays for nums1 and nums2
        int[] num1freq = new int[102];
        int[] num2freq = new int[102];

        // Initialize counters for intersection counts
        int count1 = 0; // Number of unique elements from nums2 present in nums1
        int count2 = 0; // Number of unique elements from nums1 present in nums2

        // Count frequencies of elements in nums1
        for (int i = 0; i < nums1.length; i++) {
            num1freq[nums1[i]]++;
        }

        // Count intersection elements in nums2
        for (int i = 0; i < nums2.length; i++) {
            if (num1freq[nums2[i]] != 0) {
                count1++;
            }
        }

        // Count frequencies of elements in nums2
        for (int i = 0; i < nums2.length; i++) {
            num2freq[nums2[i]]++;
        }

        // Count intersection elements in nums1
        for (int i = 0; i < nums1.length; i++) {
            if (num2freq[nums1[i]] != 0) {
                count2++;
            }
        }

        // Create result array
        int[] ans = new int[2];
        ans[0] = count2; // Number of unique elements from nums1 present in nums2
        ans[1] = count1; // Number of unique elements from nums2 present in nums1

        return ans;
    }
}