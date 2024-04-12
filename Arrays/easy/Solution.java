import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
          List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(a[i]);
            }
            stack.push(a[i]);
        }
        return result;
    }
}