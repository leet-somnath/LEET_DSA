import java.util.*;
import java.io.*;

public class A_Remove_Smallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && Math.abs(a[i] - a[j]) <= 1 && a[i] > 0 && a[j] > 0) {
                        if (a[i] > a[j]) {
                            a[j] = -1;
                        } else
                            a[i] = -1;
                    }

                }

            }
            int c = 0;
            for (int i : a) {
                if (i != -1)
                    c++;
            }
            if (c == 1 || c == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}