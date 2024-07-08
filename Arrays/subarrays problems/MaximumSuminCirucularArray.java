import java.io.*;
import java.util.*;

public class MaximumSuminCirucularArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int curr = 0, sum = Integer.MIN_VALUE, flag = 0, stindex = 0;
            for (int i = 0; i < n; i++) {
                curr += arr[i];
                     sum = Math.max(sum, curr);
                if (curr < 0)
                    curr = 0;
           
                stindex+=arr[i];
                }
            for(int i=0;i<n;i++)
                arr[i]*=-1;
            int curr1 = 0, sum1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                curr1 += arr[i];
                  sum1 = Math.max(sum1, curr1);
                if (curr1 < 0)
                    curr1 = 0;
              
                
                }
            if(stindex==-sum1)
                System.out.println(sum);
            else
        System.out.println(Math.max(sum,(stindex+sum1)));
            }
            
        
    }
}
