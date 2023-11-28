import java.util.Scanner;

public class A_Divisibility_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n % k == 0)
                System.out.println(0);
            else {

                int res = n / k;
                System.out.println((res + 1) * k - n);
            }
        }
        sc.close();
    }
}