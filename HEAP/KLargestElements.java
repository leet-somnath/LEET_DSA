import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 3;
        printKLargestElements(arr, k);
    }

    public static void printKLargestElements(int[] arr, int k) {
        // Create a min-heap with initial capacity k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add elements to the min-heap
        for (int num : arr) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
System.out.println("kth largest is "+minHeap.peek());
        // Print the k largest elements
        System.out.println("The " + k + " largest elements are:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}
