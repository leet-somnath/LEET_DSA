import java.util.*;

public class BitonicElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(bitonic(arr));
        sc.close();
    }

    public static int bitonic(int arr[]) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                    return mid;
                } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                    l = mid + 1;  // Add 1 to l
                } else {
                    h = mid - 1;  // Subtract 1 from h
                }
            } else {
                // Handle the case when mid is at the boundaries
                break;
            }
        }
        return -1;
    }
}
