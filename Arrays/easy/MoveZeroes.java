/*

Given an integer array, in-place move all zeros present in it to the end. The solution should maintain the relative order of items in the array and should not use constant space.

Input : [6, 0, 8, 2, 3, 0, 4, 0, 1]
Output: [6, 8, 2, 3, 4, 1, 0, 0, 0]

*/

//solution-->
/*
 first move all the nonzero elements in array then append remainings zeros 

 */
package Arrays.easy;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String args[]) {
        int x[] = {6, 0, 8, 2, 3, 0, 4, 0, 1};
        moveZeroes(x);
        System.out.println(Arrays.toString(x));
    }

    public static void moveZeroes(int x[]){
       int nonzeroIndex = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] != 0) {
                x[nonzeroIndex] = x[i];
                nonzeroIndex++;
            }
        } 
        
        while (nonzeroIndex < x.length) {
            x[nonzeroIndex] = 0;
            nonzeroIndex++;
        }
    }
    public static void moveZeroes(int arr[])
    {
        int low=0,high=x.length-1;
        while (low<high) {
            if(arr[low]==0)
            {
                int temp=arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
                high--;
            }
            else
            {
                low++;
            }
        }
    }
}