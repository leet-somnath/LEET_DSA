/*Given an array of elements containing 0's and 1's. You have to find the length of longest contiguous 1's.

Input Format

First line of input contains N - size of the array. The next line contains the N integers of array A.

Constraints

1 <= N <= 1000

Output Format

Print the length of longest contiguous 1's.

Sample Input :-
10
1 0 0 1 0 1 1 1 1 0 
Sample Output :-
4
*/

package Arrays.easy;

import java.util.*;

public class LongestContiguousOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x[] = new int[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = sc.nextInt();
        }
        System.out.println(Longest(x));
    }

    public static int Longest(int x[]) {
        int count = 0, temp = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1) {
                count++;
                temp = Math.max(temp, count);
            } else {
                count = 0;
            }
        }
        return temp;
    }

}
