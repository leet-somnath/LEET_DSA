import java.util.*;

public class ClosestGreatestElement_on_leftside {
    public static void main(String[] args) {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        printArray(closestGreatestLeft(price, n));
    }

    public static int[] closestGreatestLeft(int arr[], int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1; // No greater element found
            } else {
                result[i] = stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

    static void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
