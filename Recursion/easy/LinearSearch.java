import java.util.*;
import java.io.*;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target=sc.nextInt(),i=0;
            System.out.println(linearsearch(arr,target,i));
        sc.close();
    }
    public static boolean linearsearch(int arr[],int target,int i)
    {
        if(arr[i]==target)
        return true;
        if(i==arr.length-1)
        return false;
        return linearsearch(arr,target,i+1);
    }
}