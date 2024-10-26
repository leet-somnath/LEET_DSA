import java.util.*;
import java.io.*;

public class PrintingSubsequenceWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println("Subsequences with sum " + k + " are:");
        subseqgen(arr, 0, k);
        System.out.println("Total number of subsequences are " + c);
        sc.close();
    }

    static ArrayList<Integer> arrs = new ArrayList<>();
    static int c = 0;

    public static void subseqgen(int[] arr, int i, int k) {
        if (i == arr.length) {
            if (k == 0) {
                for (Integer y : arrs)
                    System.out.print(y + " ");
                System.out.println();
                c++;
            }
            return;
        }

        // Include the current element and subtract it from k
        arrs.add(arr[i]);
        subseqgen(arr, i + 1, k - arr[i]);

        // Exclude the current element and backtrack
        arrs.remove(arrs.size() - 1);
        subseqgen(arr, i + 1, k);
    }
}
