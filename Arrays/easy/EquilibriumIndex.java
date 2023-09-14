/*

Given an integer array, return all equilibrium index in it. For an array `A[0..n-1]`, index `i` is an equilibrium index if the sum of elements of subarray `A[0…i-1]` is equal to the sum of elements of subarray `A[i+1…n-1]`.

Input : [0, -3, 5, -4, -2, 3, 1, 0]
Output: {0, 3, 7}
Explanation: For each index `i` in the output, A[0] + A[1] + … + A[i-1] = A[i+1] + A[i+2] + … + A[n-1]

Input : [-7, 3, 7, -3, 1]
Output: {4}
Explanation: `n-1` is an equilibrium index if A[0] + A[1] + … + A[n-2] sums to 0.

Input : [1, 2, -4, 2]
Output: {0}
Explanation: 0 is an equilibrium index if A[1] + A[2] + … + A[n-1] sums to 0.

*/
 //solution-->

 /*
  It calculates the total sum of all elements in the array.
It iterates through the array, keeping track of the sum of elements on the right side of each index.
If the sum of the elements on the left side is equal to the sum on the right side, the index is added to the result list.
The loop runs from the backside of the array to find the equilibrium indices.
Finally, it returns the list of equilibrium indices found.
  */

package Arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class EquilibriumIndex {
    public static void main(String args[]) {
        int x[] = { 0, -3, 5, -4, -2, 3, 1, 0 };
        List<Integer> res = findIndices(x);
        System.out.println(res);
    }

    public static List<Integer> findIndices(int x[]) {
        List<Integer> indices = new ArrayList<>();
        int sum = 0;
        for (int num : x) {
            sum += num;
        }
        int rightSum = 0;
        for (int i = x.length - 1; i >= 0; i--) {
            if (rightSum == (sum - rightSum - x[i])) {
                indices.add(i);
            }
            rightSum += x[i];
        }
        return indices;
    }
}