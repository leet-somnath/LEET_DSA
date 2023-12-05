import java.util.*;

public class A_Binary_Imbalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            boolean containsZero = s.contains("0");
            System.out.println(containsZero ? "YES" : "NO");
        }

        sc.close();
    }
}
