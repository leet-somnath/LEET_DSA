import java.util.*;
import java.io.*;

public class Print_Right_Angled_Triangle_Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1; i < n-i+1; i++) {
                System.out.println(" ");
            }
            for (int i = n-i+1; i ; i++) {
                
            }
        }
        sc.close();
    }
}