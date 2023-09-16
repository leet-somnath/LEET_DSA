/*

Given an integer array, in-place reverse it without using any inbuilt functions.

Input : [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]

*/

//method-1:-using 2 pointer tecnique

package Arrays.easy;
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        reverseArray(arr);

        System.out.println("Reversed array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}

// method-2 :-using stack
/*
 package Arrays.easy;
 
 import java.util.*;
 
 public class ReverseArray {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         Stack<Integer> stack = new Stack<>();
         int n = sc.nextInt();
         for (int i = 0; i < n; i++) {
             int num = sc.nextInt();
             stack.push(num);
         }
         System.out.println("Reverse order:");
 
         while (!stack.isEmpty()) {
             int num = stack.pop();
             System.out.print(num + " ");
         }
 
         sc.close();
     }
 }
 */
