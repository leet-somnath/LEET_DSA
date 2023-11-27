



/*

Given an integer array, find a pair with the maximum product in it.

Each input can have multiple solutions. The output should match with either one of them.

Input : [-10, -3, 5, 6, -2]
Output: (-10, -3) or (-3, -10) or (5, 6) or (6, 5)

Input : [-4, 3, 2, 7, -5]
Output: (3, 7) or (7, 3)

If no pair exists, the solution should return null.

Input : [1]
Output: null

*/

//solution:-->

/*
        1.sorting the array ==>{-10,-3,-2,5,6}
        2.finding the product of first 2 elements and last two elements respectively and comparing them
        3.returning the pair
*/

package Arrays.easy;

import java.util.Arrays;

public class Maxproduct {
    public static void main(String[] args) {
        int array[] = { -10, -3, 5, 6, -2 };
        int ans[] = findpair(array);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] findpair(int[] array) {
       
        int len=array.length;
        if (len < 2) {
            return null;
        }

        Arrays.sort(array);
        int maxProduct = array[len- 2] * array[len - 1];
        int maxAbsProduct = array[0] * array[1];

        if (maxProduct > maxAbsProduct) {
            return new int[]{array[len - 2], array[len - 1]};
        } else {
            return new int[]{array[0], array[1]};
        }
    
    }
}
