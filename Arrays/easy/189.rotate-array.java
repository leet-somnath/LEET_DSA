/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
      int temp[]=new int[k];
      int n=nums.length;
      for(int i=n-k;i<n;i++)
      temp[k++]=nums[i];
      for(int i=0;i<n-k;i++)
      temp[k++]=nums[i];
      for(int i=0;i<n;i++)
      nums[i]=temp[i];
    }
}
// @lc code=end

/*import java.util.Arrays;

public class ArrayShiftAndReverse {

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void clockwiseShift(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    static void anticlockwiseShift(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        clockwiseShift(array, k);
        System.out.println("Clockwise Shifted and Reversed Array: " + Arrays.toString(array));

        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        
        anticlockwiseShift(array, k);
        System.out.println("Anticlockwise Shifted and Reversed Array: " + Arrays.toString(array));
    }
}
 */