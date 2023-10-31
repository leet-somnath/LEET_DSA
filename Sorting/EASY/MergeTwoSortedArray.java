import java.util.Scanner;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int arr2[] = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        merge(arr, n, arr2, m);

        sc.close();
    }

    public static void merge(int arr[], int n, int arr2[], int m) {
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr[i] < arr2[j]) {
                System.out.print(arr[i] + " ");
                i++;
            } else {
                System.out.print(arr2[j] + " ");
                j++;
            }
        }
        while (i < n) {
            System.out.print(arr[i] + " ");
            i++;
        }
        while (j < m) {
            System.out.print(arr2[j] + " ");
            j++;
        }
    }
}