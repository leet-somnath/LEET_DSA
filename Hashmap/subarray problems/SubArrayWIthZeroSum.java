import java.util.*;
import java.io.*;

public class SubArrayWIthZeroSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int flag = 0, prefix_sum = 0;
        Set<Integer> x = new HashSet<>();
        for (int i : arr) {
            prefix_sum += i;
            if (x.contains(prefix_sum)) {
                flag = 1;

                break;
            } else if (prefix_sum == 0) {
                flag = 1;

                break;
            }
            x.add(prefix_sum);
        }
        if (flag == 1)
            System.out.println(true);
        else
            System.out.println(false);
        sc.close();
    }
}