import java.util.Scanner;

public class A_Elephant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input
        int x = scanner.nextInt();

        // Calculate the minimum number of steps
        int steps = (x + 4) / 5;

        // Print the result
        System.out.println(steps);

        // Close the scanner
        scanner.close();
    }
}
