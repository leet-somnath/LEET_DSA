import java.util.List;

public class SearchTargetRotaedArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        int minIndex = findMinIndex(A);

        if (B == A.get(minIndex)) {
            return minIndex;
        } else if (B > A.get(minIndex) && B <= A.get(A.size() - 1)) {
            return binarySearch(A, B, minIndex, A.size() - 1);
        } else {
            return binarySearch(A, B, 0, minIndex - 1);
        }
    }

    private int findMinIndex(List<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) > arr.get(high)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int binarySearch(List<Integer> arr, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
