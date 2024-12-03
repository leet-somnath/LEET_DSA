public // Java program to find Minimum swaps required to bring all
// elements less than or equal to k together
import java.util.Arrays;

public class MinSwapsToBringElementTogetherWIthLessorEqualK {

    // Function for finding the minimum number of swaps
    // required to bring all the numbers less
    // than or equal to k together.
    static int minSwap(int[] arr, int n, int k) {
        // Find the number of elements <= k
        int good = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k)
                good += 1;
        }

        // Initialize min swaps with good as the max possible
        // value
        int bad = 0, minSwaps = good;
        for (int i = 0; i < n; i++) {
            // If the current element > k, then increment the
            // count of bad elements in the current sliding
            // window
            if (arr[i] > k) {
                bad += 1;
            }
            // If we complete the first sliding window,
            // calculate min swaps
            if (i == good - 1) {
                minSwaps = Math.min(minSwaps, bad);
            } else if (i >= good) {
                // Exclude the elements from the start of the
                // sliding window to maintain its size as 'good'
                if (arr[i - good] > k)
                    bad -= 1;
                // For every sliding window of size 'good', find
                // the minimum swaps required
                minSwaps = Math.min(minSwaps, bad);
            }
        }
        // Return the minimum swaps
        return minSwaps;
    }

    // Driver's code
    public static void main(String[] args) {
        // Sample Input
        int[] arr1 = { 2, 7, 9, 8, 5, 7, 4 };
        int n = arr1.length;
        int k = 5;

        System.out.println(minSwap(arr1, n, k));
    }
}
 {
    
}
