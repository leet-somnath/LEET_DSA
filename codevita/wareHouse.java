import java.util.*;
import java.io.*;

public class wareHouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int w = sc.nextInt();
        Arrays.sort(arr);
        int n = arr.length;
        int low = 0, high = n - 1;
        int cnt = 0;
        while (low <= high) {
            if (arr[low] + arr[high] <= w) {
                low++;
            }
            high--;
            cnt++;
        }
        System.out.print(cnt);
        sc.close();
    }

}