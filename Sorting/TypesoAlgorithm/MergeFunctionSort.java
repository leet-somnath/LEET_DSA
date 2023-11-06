import java.util.*;
public class MergeFunctionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        merge_sort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }

    public static void merge_sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void merge(int arr[], int l, int m, int r) {
        int leftsize = m - l + 1;
        int rightsize = r - m;

        int leftarr[] = new int[leftsize];
        int rightarr[] = new int[rightsize];

        for (int i = 0; i < leftsize; i++) {
            leftarr[i] = arr[i + l];
        }

        for (int i = 0; i < rightsize; i++) {
            rightarr[i] = arr[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (j < rightsize && i < leftsize) {
            if (rightarr[j] < leftarr[i]) {
                arr[k] = rightarr[j];
                j++;
                k++;
            } else {
                arr[k] = leftarr[i];
                i++;
                k++;
            }
        }

        // edge case
        while (j < rightsize) {
            arr[k] = rightarr[j];
            j++;
            k++;
        }

        while (i < leftsize) {
            arr[k] = leftarr[i];
            i++;
            k++;
        }
    }
}