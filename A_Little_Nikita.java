import java.util.*;

public class A_Little_Nikita {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            if (n >= m && (n - m) % 2 == 0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        sc.close();
    }
}
