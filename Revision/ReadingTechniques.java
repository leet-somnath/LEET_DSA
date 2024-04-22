import java.util.*;
import java.io.*;

public class ReadingTechniques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
         * we dont know how many integers or character use may enter,but we have to read
         * until
         * he writes
         */
        // for integers
        int arr1[] = new int[100];
        int m = 0;
        while (sc.hasNextInt()) {
            arr1[m] = sc.nextInt();
        }
        /*
         * for character
         * while (sc.hasNext()) {
         * arr1[m]=sc.next().charAt(0);
         * }
         */

        /*
         * to read integers with comma or any deleimeter seperated using tokenizer
         */

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

        String[] s = str2.split(":");
        int[] arr2 = new int[s.length];
        for (int k = 0; k < s.length; k++) {
            arr2[k] = Integer.parseInt(s[k].trim());
        }

        // using BufferReader
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try{
        System.out.print("Enter an integer: ");
        int intValue = Integer.parseInt(reader.readLine());
        System.out.println("You entered an integer: " + intValue);

        // Read a character
        System.out.print("Enter a character: ");
        char charValue = (char) reader.read();
        reader.readLine(); // Consume the newline character
        System.out.println("You entered a character: " + charValue);

        // Read a double
        System.out.print("Enter a double: ");
        double doubleValue = Double.parseDouble(reader.readLine());
        System.out.println("You entered a double: " + doubleValue);

        // Read a string
        System.out.print("Enter a string: ");
        String stringValue = reader.readLine();
        System.out.println("You entered a string: " + stringValue);

        // Read a long
        System.out.print("Enter a long: ");
        long longValue = Long.parseLong(reader.readLine());
        System.out.println("You entered a long: " + longValue);

        }
        catch(IOException e)
        {

            System.out.println(e);
        }

        sc.close();
    }
}