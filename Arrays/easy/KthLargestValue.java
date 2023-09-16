/*

Given an integer array, find k'th largest element in the array where k is a positive integer less than or equal to the length of array.

Input : [7, 4, 6, 3, 9, 1], k = 2
Output: 7
Explanation: The 2nd largest array element is 7

Input : [1, 5, 2, 2, 2, 5, 5, 4], k = 4
Output: 4
Explanation: The 4th largest array element is 4

*/

package Arrays.easy;
import java.util.*;
public class KthLargestValue {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < arr.length; i++) {
                    arr[i]=sc.nextInt();
                }
                int k = sc.nextInt();
                //sorting
                Arrays.sort(arr);
                System.out.println(arr[n-k]);
                sc.close();
    }
}
