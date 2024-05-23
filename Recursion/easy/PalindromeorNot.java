import java.util.*;
import java.io.*;

public class PalindromeorNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(isPalindrome(str));
        sc.close();
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
    }
}