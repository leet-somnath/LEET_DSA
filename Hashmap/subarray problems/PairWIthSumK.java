
/*
 * given unsorted array ,we have to find whether a pair exist with sum=k or not
 */
import java.util.*;
import java.io.*;

public class PairWIthSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k=sc.nextInt();
        int flag=0;
        Map<Integer,Integer> x=new HashMap<>();
        for(int i:arr)
        {
             if(x.containsKey(i))
             {
                flag=1;
                break;
             }
             else
             {
                x.put(Math.abs(k-i), 0);
             }
        }
        if(flag==1)
        {
            System.out.println(true);
        }
        else
        System.out.println(false);
        sc.close();
    }
}