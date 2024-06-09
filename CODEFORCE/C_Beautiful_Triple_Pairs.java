import java.util.Scanner;

public class C_Beautiful_Triple_Pairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // number of test cases

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt(); // length of the array
            int[] arr = new int[n]; // elements of the array

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int beautifulPairs = 0;
            for (int i = 0; i < n - 2; i++) {
                if ((arr[i] != arr[i + 1] && arr[i + 1] == arr[i + 2]) ||
                    (arr[i] == arr[i + 1] && arr[i + 1] != arr[i + 2]) ||
                    (arr[i] == arr[i + 2] && arr[i] != arr[i + 1])) {
                    beautifulPairs++;
                }
            }

            System.out.println(beautifulPairs);
        }
    }
}
