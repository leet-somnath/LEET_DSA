/*
here what we do is imagining the array in sorted and unsorted array ,intially sorted array contains 
0th element and else in unsorted array,now we start the loop from unsorted array
ie from i=1,and store the first element of unsorted array into a key=arr[i] then we 
will find the postion in sorted array where the key can be inserted such that sorted array
remains sorted, by running a loop from j=i-1  till j>=0 and arr[j]>key,till then we 
shift all the elements in sorted array by arr[j+1]=arr[j] and finally when we find the 
smaller element than key, the loop will stop
and we will insert the key  



 */

import java.util.*;
import java.io.*;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        insertsort(arr);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }

    public static void insertsort(int[] arr) {
        int n=arr.length;
        for (int i = 1; i < n; i++) {
            //unsorted part begins
            int key=arr[i];
            int j=i-1;//last index in sorted part
            while (j>=0 && arr[j]>key) {
                arr[j+1]=arr[j];//moving elements
                j--;
            }
            arr[j+1]=key;//inserting key
        }
    }
}