import java.util.*;
import java.io.*;

public class StringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(stringlength(arr,0));
        sc.close();
    }
    public static int stringlength(int arr[],int i)
    {
        if(i==arr.length)
        {
            return 0;
        }
        return 1+stringlength(arr,i+1);+
    }
}