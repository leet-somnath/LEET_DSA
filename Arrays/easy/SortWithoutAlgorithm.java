/*
this problems also Dutch national flag problem
Given an array containing only 0’s, 1’s, and 2’s, in-place sort it in linear time and using constant space.
and any sorting algrotithm is not recommended.
Input : [0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2]

*/
//three-way partioning method

import java.util.*;

public class SortWithoutAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int start = 0, mid = 0;
        int pivot = 1;
        int end = A.length - 1;

        while (mid <= end) {
            if (A[mid] < pivot) // current element is 0
            {
                swap(A, start, mid);
                ++start;
                ++mid;
            } else if (A[mid] > pivot) // current element is 2
            {
                swap(A, mid, end);
                --end;
            } else { // current element is 1
                ++mid;
            }
        }
        sc.close();
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
// my solutioh:-
/*
 * import java.util.*;
 * 
 * public class SortWithoutAlgorithm {
 * public static void main(String args[]){
 * Scanner sc = new Scanner(System.in);
 * int n=sc.nextInt();
 * int arr[]=new int[n];
 * for(int i=0;i<n;i++){
 * arr[i]=sc.nextInt();
 * }
 * int zero=0,one=0,two=0;
 * for(int i=0;i<n;i++){
 * if(arr[i]==0)
 * zero++;
 * else if(arr[i]==1)
 * one++;
 * else
 * two++;
 * }
 * for(int i=0;i<n;i++){
 * if(zero-- >0)
 * arr[i]=0;
 * if(zero==0 && one-- >=0)
 * arr[i]=1;
 * if(zero==0 && one==0 && two-- >=0)
 * arr[i]=2;
 * }
 * System.out.println(Arrays.toString(arr));
 * }
 * }
 */