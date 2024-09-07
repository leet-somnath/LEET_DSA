import java.util.Scanner;

public class RankofStringinPermuationinLexiographicallyWIthDuplicates {
    static int[] d_count = new int[52];

    static long fac(long n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }

    static long lexRank(String s) {
        long n = s.length();
        long t_count = 1;

        for (int i = 0; i < s.length(); i++) {
            long less_than = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) > s.charAt(j)) {
                    less_than++;
                }
            }

            for (int j = 0; j < 52; j++)
                d_count[j] = 0;

            for (int j = i; j < s.length(); j++) {
                if (Character.isUpperCase(s.charAt(j)))
                    d_count[s.charAt(j) - 'A']++;
                else
                    d_count[s.charAt(j) - 'a' + 26]++;
            }

            long d_fac = 1;
            for (int ele : d_count)
                d_fac *= fac(ele);

            t_count += fac(n - i - 1) * less_than / d_fac;
        }
        return t_count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            String s = scanner.nextLine();
            System.out.println(lexRank(s));
        }

        scanner.close();
    }
}