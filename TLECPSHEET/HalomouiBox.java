//https://codeforces.com/problemset/problem/1903/A


import java.util.*;
import java.io.*;

public class HalomouiBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int c=0;
        for (int i = 0; i < arr.length; i++) {
            if(i==0)
            {
                if(arr[i]<=arr[n-1] || arr[i]<arr[i+1])
                c++;
            }
            else
            {
                if(i!=n-1)
                if(arr[i]<=arr[i+1] || arr[i]>=arr[i-1])
                c++;
                
            if(i==n-1 && (arr[i]>=arr[i-1] || arr[i]>=arr[0])) 
            c++;
            }
        }
        System.out.println(n-c);
        sc.close();
    }
}
