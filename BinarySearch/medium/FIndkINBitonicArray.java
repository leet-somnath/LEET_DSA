import java.util.Scanner;

public class FIndkINBitonicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element to be searched");
        int k = sc.nextInt();
        System.out.println(solve(arr, k));
        sc.close();
    }

    public static int solve(int[] arr, int k) {
        int bindex = bitonic(arr, 0, arr.length - 1);

        // Search in the ascending part
        int res1 = ascendSearch(arr, k, bindex - 1);
        if (res1 != -1) {
            return res1;
        }

        // Search in the descending part
        int res2 = descendSearch(arr, k, bindex);
        return res2;
    }

    public static int descendSearch(int arr[], int k, int range) {
        int low = range, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                low = mid + 1; // Update low for descending order
            } else {
                high = mid - 1; // Update high for descending order
            }
        }
        return -1;
    }

    public static int ascendSearch(int arr[], int k, int range) {
        int low = 0, high = range;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                low = mid + 1; // Update low for ascending order
            } else {
                high = mid - 1; // Update high for ascending order
            }
        }
        return -1;
    }

    public static int bitonic(int[] arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    /*
     * public static int bitonic(int[] arr, int low, int high) {
     * if (low == high) {
     * return low;
     * }
     * 
     * int mid = low + (high - low) / 2;
     * 
     * if (arr[mid] > arr[mid + 1]) {
     * return bitonic(arr, low, mid);
     * } else {
     * return bitonic(arr, mid + 1, high);
     * }
     * }
     */

    /*
     * public static int bitonic(int arr[]) {
     * int l = 0, h = arr.length - 1;
     * while (l <= h) {
     * int mid = (l + h) / 2;
     * if (mid > 0 && mid < arr.length - 1) {
     * if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
     * return mid;
     * } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
     * l = mid; // Add 1 to l
     * } else {
     * h = mid; // Subtract 1 from h
     * }
     * } else {
     * // Handle the case when mid is at the boundaries
     * if (mid == 0 && arr[mid] > arr[mid + 1]) {
     * return mid;
     * }
     * if (mid == arr.length - 1 && arr[mid] > arr[mid - 1]) {
     * return mid;
     * }
     * break;
     * }
     * }
     * return -1;
     * }
     */
}