import java.util.*;
import java.io.*;

public class A_In_Search_of_an_Easy_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = 0;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (k == 1)
                c++;
        }
        if (c >= 1)
            System.out.println("HARD");
        else
            System.out.println("EASY");

        sc.close();
    }
}