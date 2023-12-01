
/**
 * The FindSecondMaximumOptimal class finds the second
 *  largest element in an array of integers.
 */
import java.util.Scanner;

public class FindSecondMaximumOptimal {
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
        int secondlarge = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != large && arr[i] > arr[secondlarge])
                secondlarge = i;
        }
        System.out.println("second largest is" + arr[secondlarge]);
        sc.close();
    }
}