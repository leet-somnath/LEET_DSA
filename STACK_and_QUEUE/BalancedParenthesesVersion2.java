import java.util.*;

public class BalancedParenthesesVersion2 {

    public static String isBalanced(String s) {
        Deque<Character> x = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                x.push(c);
            else {
                if (x.isEmpty() == true)
                    return "NO";
                else
                    x.pop();
            }
        }
        return (x.isEmpty() == true ? "YES" : "NO");
    }

    public static void main(String[] args) {
        String testString = "()()(()())"; // Example test string
        System.out.println("Is balanced? " + isBalanced(testString));
    }
}
