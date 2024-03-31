import java.util.*;
public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello, World!";
        String reversed = reverseString(str);
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversed);
    }

    public static String reverseString(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        // Add characters of the string to the deque in reverse order
        for (int i = str.length() - 1; i >= 0; i--) {
            deque.offerLast(str.charAt(i));
        }

        // Construct the reversed string from the characters in the deque
        StringBuilder reversed = new StringBuilder();
        while (!deque.isEmpty()) {
            reversed.append(deque.pollLast());
        }

        return reversed.toString();
    }
}
