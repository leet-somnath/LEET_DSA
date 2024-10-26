import java.util.*;
import java.io.*;

public class hi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int min = Integer.MAX_VALUE, sum = 0;
        int total = Arrays.stream(arr).sum();
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum < 0)
                sum = 0;
            min = Math.max(sum, total - sum);
        }
        System.out.println(min);
        sc.close();
    }
}