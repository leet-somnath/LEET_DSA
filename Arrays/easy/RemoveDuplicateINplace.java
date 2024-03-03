import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class RemoveDuplicateINplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[i]!=arr[j])
            {
                arr[i+1]=arr[j];
                
                i++;
            }
           
        }
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}