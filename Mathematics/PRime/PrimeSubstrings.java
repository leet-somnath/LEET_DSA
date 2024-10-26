import java.util.*;

public class PrimeSubstrings {

    // Sieve of Eratosthenes to generate prime numbers up to maxVal
    private static Set<Integer> sieveOfEratosthenes(int maxVal) {
        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;  // 0 and 1 are not primes

        for (int p = 2; p * p <= maxVal; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= maxVal; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        Set<Integer> primes = new HashSet<>();
        for (int p = 2; p <= maxVal; p++) {
            if (isPrime[p]) {
                primes.add(p);
            }
        }
        return primes;
    }

    // Function to get all prime substrings from a string
    public static List<String> getPrimeSubstrings(String s) {
        int maxVal = Integer.parseInt(s);  // Maximum possible number from the string
        Set<Integer> primes = sieveOfEratosthenes(maxVal);
        Set<String> result = new HashSet<>();

        // Generate all substrings and check if they are prime
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (substring.charAt(0) == '0') {
                    continue;  // Skip numbers with leading zeros
                }
                int num = Integer.parseInt(substring);
                if (primes.contains(num)) {
                    result.add(substring);
                }
            }
        }

        List<String> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);  // Sort the result lexicographically
        return sortedResult;
    }

    public static void main(String[] args) {
        String s = "11373";
        List<String> primeSubstrings = getPrimeSubstrings(s);
        System.out.println("Prime substrings: " + primeSubstrings);
    }
}
