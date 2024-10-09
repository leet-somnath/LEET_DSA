import java.util.*;
import java.io.*;

public class LonelyElementinSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(lonely(arr));
        sc.close();
    }

    public static int lonely(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even so we can compare pairs
            if (mid % 2 != 0) {
                mid--;
            }

            // If pair is found, move the left pointer to mid + 2
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        // At the end of the loop, left will point to the lonely element
        return nums[left];
    }
}