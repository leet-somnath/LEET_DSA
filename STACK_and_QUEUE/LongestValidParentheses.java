import java.util.*;
import java.io.*;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("Longest valid parentheses: " + longestValidParentheses(s));
        sc.close();
    }

    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // To handle the case when the valid substring starts from index 0
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Push the index of opening parenthesis to the stack
            if (c == '(') {
                stack.push(i);
            } else {
                // Pop the top index for closing parenthesis
                stack.pop();

                // If stack is not empty, calculate the valid substring length
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    // If stack is empty, push the current index
                    stack.push(i);
                }
            }
        }

        return maxLength;
    }
}
