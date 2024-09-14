import java.util.*;

public class LargestConcatenatedNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            Integer[] arr = new Integer[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    String str1 = String.valueOf(a) + String.valueOf(b);
                    String str2 = String.valueOf(b) + String.valueOf(a);
                    return str2.compareTo(str1);
                }
            });

            StringBuilder result = new StringBuilder();
            for (int num : arr) {
                result.append(num);
            }

            System.out.println(result);
        }

        scanner.close();
    }
}