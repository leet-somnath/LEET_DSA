import java.util.PriorityQueue;

public class KSortedArraySorter {

    public static void sortKSortedArray(int[] arr, int k) {
        // Create a min-heap (priority queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert the first k+1 elements into the min-heap
        int n = arr.length;
        for (int i = 0; i <= k && i < n; i++) {
            minHeap.add(arr[i]);
        }

        // For the rest of the elements, do the following
        int targetIndex = 0;
        for (int i = k + 1; i < n; i++) {
            arr[targetIndex++] = minHeap.poll(); // Remove the smallest element and add to the array
            minHeap.add(arr[i]); // Add the next element from the array into the heap
        }

        // Extract remaining elements from the heap and place in the array
        while (!minHeap.isEmpty()) {
            arr[targetIndex++] = minHeap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 5, 4, 8};
        int k = 3;
        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        sortKSortedArray(arr, k);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
