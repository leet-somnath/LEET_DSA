/*
 * An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.

Examples : 

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
 */
import java.util.*;
public class MoveAllNegative {
 public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
                   int n=sc.nextInt();
                   int arr[]=new int[n];
                    for(int i=0;i<n;i++){ 
                  arr[i]=sc.nextInt();
             }
                    int low=0,high=arr.length-1;
                    while(low<high){
                        if(arr[low]<0)
                        low++;
                        else 
                        swap(arr,low,high--);
                    }
                    System.out.println(Arrays.toString(arr));
 }   
 public static void swap(int[] ar, int i, int j)
 {
     int t = ar[i];
     ar[i] = ar[j];
     ar[j] = t;
 }
}
