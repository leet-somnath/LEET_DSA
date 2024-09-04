/*
 * Ross and Rachael are afraid of prime numbers, but they are not afraid of all prime numbers. They were afraid of only a special kind of prime numbers. They are afraid of the prime numbers (without the digit zero, they love all the primes which have digits 0 in them) that remain prime no matter how many of the leading digits are omitted. For example, they are afraid of 4632647 because it doesn't have the digit 0 and each of its truncations (632647, 32647, 2647, 647, 47, and 7) are primes.

You are given a simple task, given a number of N, find out the number of primes not greater that N, that Ross and Rachael are afraid of.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line containing as single number - N.

Constraints

40 points
1 <= T <= 103
1 <= N <= 103

60 points
1 <= T <= 104
1 <= N <= 104

100 points
1 <= T <= 106
1 <= N <= 106

Output Format

For each test case, print the number of primes not greater that N, that Ross and Rachael are afraid of, separated by new line.

Sample Input 0

3
5
100
30
Sample Output 0

3
15
7
 */
import java.util.Scanner;

public class PrimeFear {
    static boolean[] arr = new boolean[1000001];
    static int[] cnt = new int[1000001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 2;
        for (int j = 0; j <= 1000000; j++) {
            arr[j] = true;
        }
        arr[0] = false;
        arr[1] = false;

        while (i * i < 1000000) {
            if (arr[i]) {
                int j = i * i;
                while (j <= 1000000) {
                    arr[j] = false;
                    j += i;
                }
            }
            i++;
        }

        int ans = 0;
        cnt[0] = 0;
        cnt[1] = 0;
        for (int k = 2; k <= 1000000; k++) {
            if (arr[k] && check(k)) {
                ans++;
            }
            cnt[k] = ans;
        }

        int queries = scanner.nextInt();
        for (int q = 0; q < queries; q++) {
            int n = scanner.nextInt();
            System.out.println(cnt[n]);
        }
        scanner.close();
    }

    static boolean check(int num) {
        if (num < 10) {
            return true;
        }
        int t = num;
        int p = 1;
        int s = 0;
        while (t > 0 && s != num) {
            int r = t % 10;
            if (r == 0) {
                return false;
            }
            s += r * p;
            if (!arr[s]) {
                return false;
            }
            p *= 10;
            t /= 10;
        }
        return true;
    }
}
