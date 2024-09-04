import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumberinRangeLtoR {
    public static void main(String[] args) {
        int limit = 1000001;
        int[] arr = new int[limit];
        for (int i = 0; i < limit; i++) {
            arr[i] = 1;
        }
        arr[0] = arr[1] = 0;

        for (int i = 2; i * i < limit; i++) {
            if (arr[i] == 1) {
                for (int j = i * i; j < limit; j += i) {
                    arr[j] = 0;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            ArrayList<Integer> number = new ArrayList<>();
            for (int i = 2; i <= Math.sqrt(b); i++) {
                if (arr[i] == 1) {
                    number.add(i);
                }
            }

            int[] t = new int[b - a + 1];
            for (int i = 0; i < t.length; i++) {
                t[i] = a + i;
            }

            if (a == 1) {
                t[0] = -1;
            }
            if (a == 0) {
                t[0] = t[1] = -1;
            }

            for (int num : number) {
                int x;
                if (a % num == 0) {
                    x = 0;
                } else {
                    x = num - (a % num);
                }

                for (int j = x; j < t.length; j += num) {
                    if (t[j] != num) {
                        t[j] = -1;
                    }
                }
            }

            for (int i : t) {
                if (i != -1) {
                    System.out.println(i);
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
