/*
 * Imagine a pilot starting the flight from the ground and flying over a series of different points at different heights. You are given an array, where A[i] represents heights.
Currently, if pilot is at altitude X at ith point, and if he wants to reach (i+1)th point, his altitude will become X+A[i].
The pilot starts at altitude 0 and wants to find the highest point he can reach during the entire journey. Your task is to print the highest altitude the pilot reaches.

Input Format

First line of input contains an integer N. Second line of input contains N space separated integers.

Constraints

1 <= N <= 1000
-1000 <= A[i] <= 1000

Output Format

Print the highest altitude the pilot can reach.

Sample Input 0

5
-5 1 5 0 -7
Sample Output 0

1
 */
package Arrays.easy;

public class MaxAltitude {
    public static void main(String[] args) {
        int[] x = { -5, 1, 5, 0, -7 };
        System.out.println(findMaximumAltitude(x));
    }

    public static int findMaximumAltitude(int[] x) {
        int max = 0;
        int current = 0;

        for (int i = 0; i < x.length; i++) {
            current += x[i];
            max = Math.max(max, current);
        }

        return max;
    }
}