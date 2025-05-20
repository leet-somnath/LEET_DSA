public class BitonicElement {
    // Function to find the index of the maximum element in a bitonic array
    public static int bitonic(int[] arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Main method to test the bitonic function
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int n = arr.length;
        int maxIndex = bitonic(arr, 0, n - 1);
        System.out.println("The maximum element is at index: " + maxIndex);
        System.out.println("The maximum element is: " + arr[maxIndex]);
    }
}

