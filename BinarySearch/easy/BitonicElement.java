
/*The provided code is a Java program that 
finds the index of a bitonic element in an array.
A bitonic element is an element that is first increasing 
and then decreasing in the array. */
import java.util.Scanner;

public class BitonicElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("index is  " + bitonic(arr));
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
                    l = mid; // Add 1 to l
                } else {
                    h = mid; // Subtract 1 from h
                }
            } else {
                // Handle the case when mid is at the boundaries
                if (mid == 0 && arr[mid] > arr[mid + 1]) {
                    return mid;
                }
                if (mid == arr.length - 1 && arr[mid] > arr[mid - 1]) {
                    return mid;
                }
                break;
            }
        }
        return -1;
    }
}
