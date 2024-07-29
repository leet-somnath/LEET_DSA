import java.util.*;
import java.io.*;

public class s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(arr[j], min);
                ans = Math.max(ans, min * (j - i + 1));
            }
        }
        System.out.println(ans);
        sc.close();
    }
}