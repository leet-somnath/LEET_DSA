import java.util.*;

public class MultiHashRabinKarp {
    static final int PRIME1 = 101; // First prime for hashing
    static final int PRIME2 = 103; // Second prime for hashing
    static final long MOD1 = 1000000007; // Modulus for hash1
    static final long MOD2 = 1000000009; // Modulus for hash2

    public static int countOccurrences(String a, String b) {
        int m = a.length();
        int n = b.length();

        if (m > n) {
            return 0; // A cannot be a substring of B if its length is greater
        }

        long hashA1 = 0, hashB1 = 0, hashA2 = 0, hashB2 = 0, power1 = 1, power2 = 1;

        // Calculate hash values and power for the pattern
        for (int i = 0; i < m; i++) {
            hashA1 = (hashA1 * PRIME1 + a.charAt(i)) % MOD1;
            hashB1 = (hashB1 * PRIME1 + b.charAt(i)) % MOD1;

            hashA2 = (hashA2 * PRIME2 + a.charAt(i)) % MOD2;
            hashB2 = (hashB2 * PRIME2 + b.charAt(i)) % MOD2;

            if (i < m - 1) {
                power1 = (power1 * PRIME1) % MOD1;
                power2 = (power2 * PRIME2) % MOD2;
            }
        }

        int count = 0;

        // Sliding window over B
        for (int i = 0; i <= n - m; i++) {
            if (hashA1 == hashB1 && hashA2 == hashB2) {
                if (b.substring(i, i + m).equals(a)) {
                    count++;
                }
            }

            // Recalculate hash for next window
            if (i < n - m) {
                hashB1 = (hashB1 - b.charAt(i) * power1 % MOD1 + MOD1) % MOD1;
                hashB1 = (hashB1 * PRIME1 + b.charAt(i + m)) % MOD1;

                hashB2 = (hashB2 - b.charAt(i) * power2 % MOD2 + MOD2) % MOD2;
                hashB2 = (hashB2 * PRIME2 + b.charAt(i + m)) % MOD2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        StringBuilder result = new StringBuilder();

        for (int test = 0; test < t; test++) {
            String[] input = sc.nextLine().split(" ");
            String a = input[0];
            String b = input[1];

            result.append(countOccurrences(a, b)).append("\n");
        }

        System.out.print(result.toString());
        sc.close();
    }
}