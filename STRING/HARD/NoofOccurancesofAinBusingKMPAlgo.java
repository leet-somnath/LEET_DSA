import java.util.Scanner;

public class NoofOccurancesofAinBusingKMPAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();

        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            String a = input[0];
            String b = input[1];

            int occur = count(a, b);
            System.out.println(occur);
        }

        sc.close();
    }

    public static int count(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();

        int[] lps = computeLPS(pattern);
        int count = 0;
        int i = 0;
        int j = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                count++;
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return count;
    }

    public static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }
}
