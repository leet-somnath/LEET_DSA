import java.util.*;

public class AllDivisor {
    public void printDivisors(int n) {
        if (n == 1) {
            System.out.print(1);
            return;
        }

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }

        Collections.sort(divisors);

        for (int divisor : divisors) {
            System.out.print(divisor + " ");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        solution.printDivisors(n);
        scanner.close();
    }
}
