import java.util.*;

public class A_Binary_Imbalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine(); 

        while (t-- > 0) {
            String s = sc.nextLine();
            boolean zero = s.contains("0");
            System.out.println(zero ? "YES" : "NO");
        }

        sc.close();
    }
}
