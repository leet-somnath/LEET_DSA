import java.util.*;

public class Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Create a string from a character array
        char arr[] = { '1', '2' };
        String str = new String(arr, 0, 2);
        System.out.println("String: " + str);
        
        // Convert string to char array
        char ar[] = str.toCharArray();
        System.out.println("Char array: " + Arrays.toString(ar));
        
        // Length of the string
        System.out.println("Length: " + str.length());
        
        // Convert integer to string
        System.out.println("Converting int to string: " + String.valueOf(77));
        
        // Convert string to integer
        System.out.println(Integer.parseInt("34334"));
        
        // Concatenation with "dom"
        String concatenatedStr = str.concat("dom");
        System.out.println("Concatenated string: " + concatenatedStr);
        
        // Check if the original string is modified
        System.out.println("Original String: " + str);
        
        // Additional String methods
        
        // charAt
        char firstChar = str.charAt(0);
        System.out.println("First character: " + firstChar);
        
        // Substring from index 2 to end of the string
        String subStr1 = str.substring(2);
        System.out.println("Substring from index 2 to end: " + subStr1);
        
        // Substring from index 1 to 3 (end index exclusive)
        String subStr2 = str.substring(1, 4);
        System.out.println("Substring from index 1 to 3: " + subStr2);
        
        // indexOf
        int index = str.indexOf("2");
        System.out.println("Index of '2': " + index);
        
        // toLowerCase
        String lowerCaseStr = str.toLowerCase();
        System.out.println("Lowercase string: " + lowerCaseStr);
        
        // toUpperCase
        String upperCaseStr = str.toUpperCase();
        System.out.println("Uppercase string: " + upperCaseStr);
        
        // Trim
        String trimmedStr = "   Hello   ";
        System.out.println("Original trimmed string: '" + trimmedStr + "'");
        System.out.println("Trimmed string: '" + trimmedStr.trim() + "'");
        
        // equals
        System.out.println(str.equals("som"));
        
        // equalignorecase
        System.out.println(str.equalsIgnoreCase("dsflkjLKJ"));
        
        // isempty
        System.out.println(str.isEmpty());
        
        /*
         * isBlank() method ::-- if a string is empty or contains only whitespace
         * characters.
         * If the string is empty or consists
         * solely of whitespace characters, it returns true; otherwise, it returns
         * false.
         */
        String str1 = ""; // Empty string
        String str2 = "  "; // String containing only whitespace characters
        String str3 = "Hello"; // Non-empty string
        System.out.println("Is str1 blank? " + str1.isBlank()); // true
        System.out.println("Is str2 blank? " + str2.isBlank()); // true
        System.out.println("Is str3 blank? " + str3.isBlank()); // false
        
        // string builder
        
        // Create a StringBuilder object with initial value "Hello"
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");
        
        // Convert StringBuilder to string
        String st2r = sb1.toString();
        System.out.println(st2r);
        
        // Append " World" to the StringBuilder
        sb1.append(" World");
        
        // Check if sb1 equals sb2
        boolean isEqual = sb1.equals(sb2);
        System.out.println("Are sb1 and sb2 equal? " + isEqual);
        
        // Insert a comma at index 5
        sb1.insert(5, ",");
        
        // Delete characters from index 5 to 7 (inclusive)
        sb1.delete(5, 7);
        
        // Replace "Hello" with "Hi"
        sb1.replace(0, 5, "Hi");
        
        // Get the index of the first occurrence of 'l' in the StringBuilder
        int firstIndex = sb1.indexOf("l");
        
        // Get the index of the last occurrence of 'l' in the StringBuilder
        int lastIndex = sb1.lastIndexOf("l");
        
        // Set the character at index 3 to 'X'
        sb1.setCharAt(3, 'X');
        
        // Get the character at index 3
        char ch = sb1.charAt(3);
        
        // Get the length of the StringBuilder
        int length = sb1.length();
        
        // Get a substring from index 3 to index 8
        String substring = sb1.substring(3, 8);
        
        // Print out the StringBuilder and the results
        System.out.println("StringBuilder: " + sb1);
        System.out.println("Index of 'l': " + firstIndex);
        System.out.println("Last index of 'l': " + lastIndex);
        System.out.println("Character at index 3: " + ch);
        System.out.println("Length of StringBuilder: " + length);
        System.out.println("Substring from index 3 to 8: " + substring);
        
        sc.close();
    }
}