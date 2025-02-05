import java.io.*;
import java.util.*;
import java.lang.Math;

public class Blast{
    public static int buggyCountStringsOfTargetLengthAndChar(int n, List<String> arr, int length, char targetChar) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i).length() == length && arr.get(i).charAt(0) == targetChar) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine().trim());

        List<String> arr = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            arr.add(scan.nextLine());
        }

        int length = Integer.parseInt(scan.nextLine().trim());
        char targetChar = scan.nextLine().charAt(0);

        int result = buggyCountStringsOfTargetLengthAndChar(n, arr, length, targetChar);

        System.out.println(result);
    }
}
