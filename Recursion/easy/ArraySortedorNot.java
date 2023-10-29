import java.util.*;

public class ArraySortedorNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(sortedOrNot(arr));
        sc.close();
    }

    public static boolean sortedOrNot(int arr[]) {
        return sortedOrNot(arr, 0);
    }

    private static boolean sortedOrNot(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return sortedOrNot(arr, i + 1);
    }
}