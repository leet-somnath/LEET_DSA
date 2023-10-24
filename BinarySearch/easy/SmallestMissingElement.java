import java.util.*;
import java.io.*;

public class SmallestMissingElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findSmallestMissing(arr, 0, arr.length - 1));

        sc.close();
    }

    public static int findSmallestMissing(int[] nums, int left, int right) {
        // base condition
        if (left > right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == mid) {
            return findSmallestMissing(nums, mid + 1, right);
        } else {

            return findSmallestMissing(nums, left, mid - 1);
        }
    }
}