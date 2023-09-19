import java.util.*;

public class A_Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int co = 0;
        while (n > 0) {
            if (sc.hasNextInt()) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if ((a + b + c) >= 2)
                    co++;
                n--; // Decrement n to eventually terminate the loop
            } else {
                break; // Exit the loop if there is no more input
            }
        }
        System.out.println(co);
        sc.close();
    }
}