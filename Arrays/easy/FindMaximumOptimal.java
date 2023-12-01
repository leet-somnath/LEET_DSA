
/**
 * The FindMaximumOptimal class finds the largest 
 * element in an array of integers.
 */
import java.util.Scanner;

public class FindMaximumOptimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int large = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[large])
                large = i;
        }
        System.out.println("largest is" + arr[large]);
        sc.close();
    }
}