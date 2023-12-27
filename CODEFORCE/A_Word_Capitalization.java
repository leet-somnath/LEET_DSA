import java.util.*;
import java.io.*;

public class A_Word_Capitalization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String ans = s.substring(0,1).toUpperCase() + s.substring(1);

        System.out.println(ans);
        sc.close();
    }
}