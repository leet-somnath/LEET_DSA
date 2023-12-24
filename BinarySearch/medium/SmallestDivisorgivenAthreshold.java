public class SmallestDivisorgivenAthreshold {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int limit = 8;
        int ans = smallestDivisor(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }

    public static int sumByD(int[] arr, int div) {
        int n = arr.length; // size of array
        // Find the summation of division values:
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) (arr[i]) / (double) (div));
        }
        return sum;
    }

    public static int smallestDivisor(int[] arr, int limit) {
        int n = arr.length; // size of array.
        if (n > limit)
            return -1;
        // Find the maximum element:
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int low = 1, high = maxi;

        // Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
