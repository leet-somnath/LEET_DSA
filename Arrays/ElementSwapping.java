import java.util.*;

public class ElementSwapping {
    public static void main(String[] args) {
        int[] arr = {1, 9, 7, 3, 2};  // Example input
        int n = arr.length;
        
        // Greedy adjacent swaps to increase the sum
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            
            // Find the largest element within the range i to n-1 (or up to 1 swap away)
            for (int j = i + 1; j < Math.min(i + 2, n); j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            
            // If swapping maximizes the sum, perform the swap
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }

        // Calculate the final strength sum
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i] * (i + 1);  // 1-based index calculation
        }

        System.out.println(result);  // Output the result
    }
}
