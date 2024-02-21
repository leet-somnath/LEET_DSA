import java.util.HashMap;
import java.util.Scanner;

public class A_Vlad_and_the_Best_of_Five {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            String testString = scanner.nextLine();
            char mostFrequentChar = processTestCase(testString);
            System.out.println(mostFrequentChar);
        }
    }

    private static char processTestCase(String string) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        charCount.put('A', 0);
        charCount.put('B', 0);

        for (char ch : string.toCharArray()) {
            charCount.put(ch, charCount.get(ch) + 1);
        }

        if (charCount.get('A') > charCount.get('B')) {
            return 'A';
        } else if (charCount.get('B') > charCount.get('A')) {
            return 'B';
        } else {
            return 'A';
        }
    }
}
