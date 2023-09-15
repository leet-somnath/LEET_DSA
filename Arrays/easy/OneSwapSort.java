/*

Given an integer array where all its elements are sorted in increasing order except two swapped elements, in-place sort it in linear time. Assume there are no duplicates in the array.

Input : [3, 8, 6, 7, 5, 9] or [3, 5, 6, 9, 8, 7] or [3, 5, 7, 6, 8, 9]
Output: [3, 5, 6, 7, 8, 9]

*/
//solution:-->

package Arrays.easy;

import java.util.Arrays;

public class OneSwapSort {
    public static void main(String args[]) {

        int array[] = { 3, 8, 6, 7, 5, 9 };
        int n = array.length;
        int firstSwapIndex = -1;
        int secondSwapIndex = -1;

        for (int i = 0; i < n - 1; i++) {
            if (array[i] >= array[i + 1]) {
                if (firstSwapIndex == -1) {
                    firstSwapIndex = i;
                } else {
                    secondSwapIndex = i + 1;
                    break;
                }
            }
        }

        // swapping the index
        int temp = array[firstSwapIndex];
        array[firstSwapIndex] = array[secondSwapIndex];
        array[secondSwapIndex] = temp;
        System.out.println(Arrays.toString(array));

    }
}
