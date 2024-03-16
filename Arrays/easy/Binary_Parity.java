package Arrays.easy;
import java.util.*;

class Binary_Parity {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Input integer
            int sum = 0;

            // Counting the number of set bits
            while (n > 0) {
                sum += n & 1;
                n = n >> 1;
            }

            // Checking the parity
            if (sum % 2 == 0)
                System.out.println("EVEN");
            else
                System.out.println("ODD");
        }
    }
}
