package Arrays.easy;

import java.util.*;

/**
 * Left_Right_Sum
 */
public class Left_Right_Sum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int b[] = new int[n];
        for (int i = 0; i < b.length; i++) {
            b[i] = Math.abs(leftsum(arr, 0, i - 1) - rightsum(arr, i + 1, arr.length - 1));
        }

        System.out.println(Arrays.toString(b));
        sc.close();
    }

    public static int leftsum(int arr[], int start, int end) {
        int lsum = 0;
        if (end == -1)
            return 0;
        for (int i = start; i <= end; i++)
            lsum += arr[i];
        return lsum;
    }

    public static int rightsum(int arr[], int start, int end) {
        int rsum = 0;
        if (start > end)
            return 0;
        for (int i = start; i <= end; i++)
            rsum += arr[i];
        return rsum;
    }
}