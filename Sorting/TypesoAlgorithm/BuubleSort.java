/**
 * The BubbleSort class implements the bubble sort algorithm 
 * to sort an array of integers in ascending order.
 */
import java.util.*;
import java.io.*;

public class BuubleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }

    public static void bubblesort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }

            }
            if (swapped == false)
                break;
        }
    }
}