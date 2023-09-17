/* you will be given two arrays which should be sorted then after
 that we have to find union of the two sorted array */
 
 //solution:-

import java.util.*;
public class SortedArrayUnion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
       HashSet<Integer> x=new HashSet<>();
       for (Integer i : arr) {
        x.add(i);
       }
       for (Integer i : arr1) {
        x.add(i);
       }
       for (Integer i : x) {
        System.out.print(i+" ");
       }
       System.out.println();
        sc.close();
    }
}
