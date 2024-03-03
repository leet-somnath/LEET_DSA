import java.util.*;
import java.io.*;

public class Sum_of_array_elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                long a = sc.nextLong();
                sum += a;
            }
            System.out.println(sum);
        }

        sc.close();
    }
}