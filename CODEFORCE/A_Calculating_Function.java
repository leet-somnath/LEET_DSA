import java.util.*;
import java.io.*;

public class A_Calculating_Function {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    long odd = 0;
        long k = sc.nextLong();
        long s=k/2;
        long r = (k / 2) + 1;
        long ev = (s) * (4 + (s - 1) * 2) / 2;

        if (k % 2 == 0)

        {
            odd = (s) * (-2 + (s - 1) * -2)/2;

        }

        else {
            odd = r * (-2 + (r - 1) * -2) / 2;

        }
        System.out.println(ev + odd);
        sc.close();
    }
}