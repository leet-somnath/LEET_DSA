import java.util.*;
import java.io.*;

public class StringTokenizerr {
    public static void main(String[] args) {
        /*
         * to read integers with comma or any deleimeter seperated using tokenizer
         */
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int arr[] = new int[100];

        int i = 0;
        StringTokenizer t = new StringTokenizer(str, ",");
        System.out.println("count of token" + t.countTokens());
        while (t.hasMoreTokens()) {
            String tok = t.nextToken().trim();
            arr[i] = Integer.parseInt(tok);
            System.out.println(arr[i++]);
        }
        System.out.println(t.countTokens());
        /*
         * 2nd way
         */
        String str2 = sc.nextLine();

        String[] tokens = str2.split(":");
        int[] arr2 = new int[tokens.length];
        for (int k = 0; k < tokens.length; k++) {
            arr2[k] = Integer.parseInt(tokens[k].trim());
        }
        sc.close();
    }
}