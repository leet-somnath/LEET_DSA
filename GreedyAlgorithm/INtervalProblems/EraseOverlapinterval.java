import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = intervals[0][1];

        // Iterate through intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // Overlap detected, increment the count of removals
                count++;
            } else {
                // No overlap, update the end to the current interval's end
                end = intervals[i][1];
            }
        }

        return count;
    }
}
