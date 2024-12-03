import java.util.*;

public class InsertInterval {

    public static List<List<Integer>> insertInterval(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // Step 1: Add all intervals that come before the newInterval (no overlap).
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        // Step 2: Merge overlapping intervals with newInterval.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval.
        result.add(Arrays.asList(newInterval[0], newInterval[1]));

        // Step 3: Add all remaining intervals (no overlap).
        while (i < n) {
            result.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = { {1, 3}, {6, 9} }; // Existing intervals
        int[] newInterval = {2, 5};             // Interval to be inserted

        List<List<Integer>> ans = insertInterval(intervals, newInterval);
        System.out.print("The updated intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }
}
