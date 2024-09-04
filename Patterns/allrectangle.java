/*
 * 5

*****
*****
*****
*****
*****
 */
import java.util.*;
import java.io.*;

public class allrectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}