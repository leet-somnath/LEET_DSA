import java.util.*;
import java.io.*;

public class LeftBinaryTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int flag = 1;
        for (int i = 0; i < n; i++) {

            if (i % 2 == 1) {
                flag = 0;

                for (int j = 0; j <= i; j++) {
                    System.out.print(flag + " ");
                    flag = 1 - flag;

                }
            } else {

                flag = 1;
                for (int j = 0; j <= i; j++) {
                    System.out.print(flag + " ");
                    flag = 1 - flag;
                }
            }
            System.out.println();
        }
        sc.close();
    }
}