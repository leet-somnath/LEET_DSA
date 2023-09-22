import java.util.*;

public class Algorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int res = binarysearch(arr, k);
        System.out.println(res);

    }

    public static int binarysearch(int arr[], int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] == k)
                return mid;
            else if (arr[mid] > k)
                high = mid - 1;
            else
                low = mid + 1;

        }
        return -1;
    }


}