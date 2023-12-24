
/*

Given a sorted array of non-negative distinct integers, find the smallest missing non-negative element in it.

Input: [0, 1, 2, 6, 9, 11, 15]
Output: 3

Input: [1, 2, 3, 4, 6, 9, 11, 15]
Output: 0

Input: [0, 1, 2, 3, 4, 5, 6]
Output: 7

*/
import java.util.*;
import java.io.*;

public class FindSmallestMissingElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n=sc.nextInt();
       int arr[]=new int[n];
        for(int i=0;i<n;i++){ 
      arr[i]=sc.nextInt();
 }
 System.out.println(findSmallestMissingNumber(arr));
        
        sc.close();
    }
    public static int findSmallestMissingNumber(int[] arr)
	{
		  int low = 0, high = arr.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            // Check if the missing number is to the left of mid or if mid is the missing number
            if (arr[mid] > mid && (mid == 0 || arr[mid - 1] == mid - 1))
            {
                return mid;
            }
            else if (arr[mid] > mid)
            {
                // Search on the left side
                high = mid - 1;
            }
            else
            {
                // Search on the right side
                low = mid + 1;
            }
        }

        // If no missing number is found, return the next possible number
        return low;
	}
}