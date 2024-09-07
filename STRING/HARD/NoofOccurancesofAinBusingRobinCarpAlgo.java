import java.util.Scanner;

public class NoofOccurancesofAinBusingRobinCarpAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = (int)1e9+7;

        while (t-- > 0) {
            int c = 0;
            String a = sc.next();
            String b = sc.next();
            long ha1 = 0, ha2 = 0, hb1 = 0, hb2 = 0;
            int m2 = a.length();
            int n = b.length();
            long p = 53, q = 97;
            long p1 = p, q1 = q;
            for (int i = 0; i < m2; i++) {
                ha1 = (ha1 + (a.charAt(i) * p1) % m) % m;
                hb1 = (hb1 + (b.charAt(i) * p1) % m) % m;
                
                    p1 = (p1 * p) % m;
            }
            for (int i = 0; i < m2; i++) {
                ha2 = (ha2 + (a.charAt(i) * q1) % m) % m;
                hb2 = (hb2 + (b.charAt(i) * q1) % m) % m;
                
                    q1 = (q1 * q) % m;
            }

            if (ha1 == hb1 && ha2 == hb2) {
                c++;
            }
            //ha1 and ha2 smaller
            long p2 = p, q2 = q;
            for (int i = m2; i < n; i++) {
                hb1 = (hb1 + (b.charAt(i) * p1) % m) % m;
                hb2 = (hb2 + (b.charAt(i) * q1) % m) % m;
                hb1 = (hb1 - (b.charAt(i - m2) * p2)%m + m) % m;
                hb2 = (hb2 - (b.charAt(i - m2) * q2)%m + m) % m;
                ha1 = (ha1 * p) % m;
                ha2 = (ha2 * q) % m;
                p1 = (p1 * p) % m;
                q1 = (q1 * q) % m;
                p2 = (p2 * p) % m;
                q2 = (q2 * q) % m;

                if (ha1 == hb1 && ha2 == hb2) {
                    c++;
                }
            }
            System.out.println(c);
        }
    }
}