package PRime;
import java.util.*;

public class PrimeFactors {

    public static void sievePrimeFactors(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Set<Integer> primeFactors = new HashSet<>();
int k=1;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && n % i == 0) {
                primeFactors.add(i);
                k*=i;
            }
        }

        System.out.println("Unique Prime Factors: " + primeFactors+" "+k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        sievePrimeFactors(n);

        scanner.close();
    }
}
