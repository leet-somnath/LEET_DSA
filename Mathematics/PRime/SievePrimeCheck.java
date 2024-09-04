import java.util.Scanner;

public class SievePrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number to check if it's prime: ");
        int n = sc.nextInt();

        // Create a sieve and determine if n is prime
        boolean isPrime = isPrimeUsingSieve(n);

        // Output the result
        if (isPrime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }

        sc.close();
    }

    public static boolean isPrimeUsingSieve(int n) {
        if (n <= 1) {
            return false; // 0 and 1 are not prime numbers
        }

        boolean[] sieve = new boolean[n + 1];

        // Initialize all entries in the sieve as true
        for (int i = 2; i <= n; i++) {
            sieve[i] = true;
        }

        // Apply Sieve of Eratosthenes
        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false; // Mark all multiples of i as non-prime
                }
            }
        }

        // Return the result for n
        return sieve[n];
    }
}
