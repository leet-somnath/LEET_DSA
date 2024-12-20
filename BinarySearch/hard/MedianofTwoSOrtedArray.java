


import java.util.*;

    public class MedianOfTwoSortedArray {
    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(b, a);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + median(a, b));
    }
}
/*
 * import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 8};
        int[] nums2 = {7, 9, 10, 11};

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median is: " + median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for efficient binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Handle edge cases for partitions
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we found the correct partition
            if (maxX <= minY && maxY <= minX) {
                // Even total length
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                }
                // Odd total length
                else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                // Move towards left in nums1
                high = partitionX - 1;
            } else {
                // Move towards right in nums1
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}

 */

/*
 * import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Create a new array list to store the combined elements
        List<Integer> mergedList = new ArrayList<>();
        
        // Add elements from both arrays into the merged list
        for (int num : nums1) {
            mergedList.add(num);
        }
        
        for (int num : nums2) {
            mergedList.add(num);
        }
        
        // Sort the merged list
        Collections.sort(mergedList);
        
        // Find the median
        int n = mergedList.size();
        
        if (n % 2 != 0) {
            // Odd size, return the middle element
            return mergedList.get(n / 2);
        } else {
            // Even size, return the average of the two middle elements
            return (mergedList.get(n / 2 - 1) + mergedList.get(n / 2)) / 2.0;
        }
    }
}

 */

