import java.util.Scanner;

public class A_Rook {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            String p = s.next();
            char c = p.charAt(0), r = p.charAt(1);

            for (char j = 'a'; j <= 'h'; j++) {
                if (j != c) System.out.println(j + "" + r);
            }

            for (char j = '1'; j <= '8'; j++) {
                if (j != r) System.out.println(c + "" + j);
            }
        }

        s.close();
    }
}
