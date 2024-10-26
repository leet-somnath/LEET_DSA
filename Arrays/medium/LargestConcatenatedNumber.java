import java.util.*;

class Solution {
    public String largestNumber(int[] arr) {
        // Convert int[] to Integer[] for the custom comparator
        Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Custom comparator to order numbers in a way that forms the largest number
        Arrays.sort(arrInteger, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String str1 = String.valueOf(a) + String.valueOf(b);
                String str2 = String.valueOf(b) + String.valueOf(a);
                return str2.compareTo(str1); // Sort in descending order of concatenated strings
            }
        });

        // If the largest number is "0", return "0" (handle edge case with multiple zeros)
        if (arrInteger[0] == 0) {
            return "0";
        }

        // Build the result
        StringBuilder result = new StringBuilder();
        for (int num : arrInteger) {
            result.append(num);
        }

        return result.toString();
    }
}
