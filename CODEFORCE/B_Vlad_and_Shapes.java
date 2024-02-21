import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B_Vlad_and_Shapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int k = 0; k < t; k++) {
            Set<Integer> s = new HashSet<>();
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                String ss = scanner.nextLine();
                if (ss.contains("1")) {
                    s.add(countOnes(ss));
                }
            }

            if (s.size() == 1) {
                System.out.println("SQUARE");
            } else {
                System.out.println("TRIANGLE");
            }
        }
        scanner.close();
    }

    public static int countOnes(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
}
