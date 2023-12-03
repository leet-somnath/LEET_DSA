import java.util.Scanner;

public class LeftRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        rotate(arr, k);

        sc.close();
    }

    /*
     * class Solution {
     * public void rotate(int[] nums, int k) {
     * k = k % nums.length; // handle cases where k is greater than the array length
     * 
     * // Reverse the entire array
     * reverse(nums, 0, nums.length - 1);
     * 
     * // Reverse the first k elements
     * reverse(nums, 0, k - 1);
     * 
     * // Reverse the remaining elements
     * reverse(nums, k, nums.length - 1);
     * }
     * 
     * private void reverse(int[] nums, int start, int end) {
     * while (start < end) {
     * int temp = nums[start];
     * nums[start] = nums[end];
     * nums[end] = temp;
     * start++;
     * end--;
     * }
     * }
     * }
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[k];
        int m = 0;

        for (int i = n - k; i < n; i++) {
            temp[m++] = nums[i];
        }

        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

}