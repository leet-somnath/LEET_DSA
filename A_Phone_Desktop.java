import java.util.Scanner;

public class A_Phone_Desktop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            int max2 = (5 / 2) * (3 / 2);
            int s2 = (y + max2 - 1) / max2;
            int used2 = y * 4;
            int remCells = s2 * 15 - used2;
            int rem1 = x - remCells;
            int s1 = (rem1 > 0) ? (rem1 + 15 - 1) / 15 : 0;
            int total = s2 + s1;
            System.out.println(total);
        }
        sc.close();
    }
}
