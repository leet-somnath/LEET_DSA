import java.util.Scanner;

public class RankofStringinPermuationinLexiographically {
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        while (t-- > 0) {
            String str = scanner.nextLine();
            int n = str.length();
            int[] cnt = new int[256];
            long mul = factorial(n);
            long rank = 1;

            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i)]++;
            }

            for (int i = 1; i < 256; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = 0; i < str.length(); i++) {
                mul /= (n - i);
                rank += mul * cnt[str.charAt(i) - 1];
                for (int j = str.charAt(i); j < 256; j++) {
                    cnt[j]--;
                }
            }

            System.out.println(rank);
        }
        scanner.close();
    }
}
