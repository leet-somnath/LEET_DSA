import java.util.Arrays;
import java.util.Scanner;
public class A_Amusing_Joke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String guestName = scanner.nextLine();
        String hostName = scanner.nextLine();
        String pileOfLetters = scanner.nextLine();

        
        String combinedNames = guestName + hostName;

        
        char[] sortedCombinedNames = combinedNames.toCharArray();
        char[] sortedPileOfLetters = pileOfLetters.toCharArray();
        Arrays.sort(sortedCombinedNames);
        Arrays.sort(sortedPileOfLetters);

        
        if (Arrays.equals(sortedCombinedNames, sortedPileOfLetters)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}