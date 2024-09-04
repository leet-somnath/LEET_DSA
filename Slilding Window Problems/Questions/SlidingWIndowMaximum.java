/*
     * Given an array of integers A and an integer B, this method finds the maximum
     * value in each sliding window of size B moving from left to right across the
     * array A.
     */
    import java.util.*;

public class SlidingWIndowMaximum {
   

    public static void main(String[] args) {
        // Example usage
        int[] A = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int B = 3;
        int[] result = slidingMaximum(A, B);
        System.out.println("Maximum values for each sliding window of size " + B + ": ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] slidingMaximum(final int[] A, int B) {
        if (A == null || A.length == 0 || B <= 0) {
            return new int[0];
        }

        int n = A.length;
        int[] result = new int[n - B + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < B; i++) {
            while (!deque.isEmpty() && A[i] >= A[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result[0] = A[deque.peekFirst()];

        for (int i = B; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - B) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && A[i] >= A[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);

            result[i - B + 1] = A[deque.peekFirst()];
        }

        return result;
    }
}
