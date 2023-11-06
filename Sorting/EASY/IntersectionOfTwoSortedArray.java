import java.util.*;
import java.io.*;

public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        intersection(arr,arr1);

        sc.close();
    }
    public static void intersection(int arr[],int arr1[])
    {
        int n=arr.length;
        int m=arr.length;
        int i=0,j=0;
        while (i<n && j<m) {
            if(i>0 && arr[i]==arr[i-1])
            {
                i++;
                continue;
            }
            if(arr[i]<arr[j])
            {
                i++;
            }
            else if(arr[i]>arr[j])
            {
                j++;
            }
            else
            {
                System.out.print(arr[i]+" ");
                i++;
                j++;
            }
            
        }
    }
}