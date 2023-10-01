import java.util.Scanner;

public class XorFromLtoR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(allxor(r) ^ allxor(l - 1));

        sc.close();
    }

    public static int allxor(int r) {
        if (r % 4 == 0) {
            return r;
        } else if (r % 4 == 1) {
            return 1;
        } else if (r % 4 == 2) {
            return r + 1;
        } else if (r % 4 == 3) {
            return 0;
        }
        return 0;
    }
}