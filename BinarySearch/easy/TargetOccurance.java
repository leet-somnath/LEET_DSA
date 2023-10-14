public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int findCount(final List<Integer> arr, int k) {
        int left = findLeftmost(arr, k);
        int right = findRightmost(arr, k);
         
        if (left > right) {
            return 0;
        } else {
            return right - left + 1;
        }
    }

    private int findLeftmost(final List<Integer> arr, int k) {
        int low = 0;
        int high = arr.size() - 1;
         
        while (low <= high) {
            int mid = low + (high - low) / 2;
             
            if (arr.get(mid) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
         
        return low;
    }

    private int findRightmost(final List<Integer> arr, int k) {
        int low = 0;
        int high = arr.size() - 1;
         
        while (low <= high) {
            int mid = low + (high - low) / 2;
             
            if (arr.get(mid) > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
         
        return high;
    }
}