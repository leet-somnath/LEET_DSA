import java.util.*;
import java.io.*;

public class ImplementAtoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int len = s.length();
        int res = 0, start = 0, a = 1;
        if (s.charAt(0) == '-') {

            start = 1;
            a = 2;
        }

        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') { // Check if the character is a digit
                int digit = ch - '0';
                res += digit * Math.pow(10, len - a);
                len--;
            } else {
                return; // Non-digit character found
            }
        }
        if (start == 1)
            System.out.println(-1 * res);
        else
            System.out.println(res);
        sc.close();
    }
}