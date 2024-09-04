public static int bitonic(int[] arr, int low, int high) {
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] > arr[mid + 1]) {
            high = mid;
        } else 
        {
            low = mid + 1;
        }
    }
    return low;
}