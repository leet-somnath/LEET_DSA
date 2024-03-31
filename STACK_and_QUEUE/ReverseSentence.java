/*
 * Given a sentence, reverse the entire sentence word-by-word.
Note: Solve using stack or in-place swap. Do not simply scan, split and print in reverse order.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each contains a sentence S of space separated words of lowercase english alphabet. All the words are separated by a single space.

Constraints

1 <= T <= 1000
1 <= len(S) <= 1000

Output Format

For each test case, print the reversed sentence, separated by newline.

Sample Input 0

3
hello world
a b c d
data structures and algorithms
Sample Output 0

world hello
d c b a
algorithms and structures data

 */


import java.util.*;

public class ReverseSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        while (T-- > 0) {
            String sentence = scanner.nextLine();
            String reversed = reverseSentence(sentence);
            System.out.println(reversed);
        }
        scanner.close();
    }

    public static String reverseSentence(String sentence) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            stack.push(word);
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            if (!stack.isEmpty()) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
