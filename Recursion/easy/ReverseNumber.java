import java.util.*;
import java.io.*;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        System.out.println(reverse(n));
        sc.close();
    }

    static int sum = 0;// global variable

    public static int  reverse(int n) {
        if (n == 0)
            return sum;
        sum = sum * 10 + n % 10;
      return  reverse(n / 10);

    }
}