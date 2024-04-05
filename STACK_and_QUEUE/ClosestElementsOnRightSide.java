import java.util.*;

public class ClosestElementsOnRightSide {
    public static void main(String[] args) {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        
        System.out.println("Closest smallest element on the right side:");
        printArray(closestSmallestRight(price, n));
        
        System.out.println("\nClosest greatest element on the right side:");
        printArray(closestGreatestRight(price, n));
    }

    public static int[] closestSmallestRight(int arr[], int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1; // No smaller element found
            } else {
                result[i] = stack.peek();
            }

            stack.push(i);
        }

        return result;
    }
    
    public static int[] closestGreatestRight(int arr[], int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
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
