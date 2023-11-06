import java.util.*;
import java.io.*;

public class MeanOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int i = 0;
        System.out.println(mean(arr, i)/n);
        
        sc.close();
    }

    public static int mean(int arr[], int i) {
        if (i == arr.length)
            return 0;
        return (arr[i] + mean(arr, i + 1));
    }
}