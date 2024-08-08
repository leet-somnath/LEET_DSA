import java.util.*;

public class  SumofXorInSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for (int i = 0; i < n; i++) { 
            arr[i] = sc.nextInt();
        }
        
        List<List<Integer>> subsets = subset(arr, n);
        int sumOfXORs = calculateSumOfXORs(subsets);
        
        System.out.println("Sum of all XORs: " + sumOfXORs);
        
        sc.close();
    }
    
    public static List<List<Integer>> subset(int[] arr, int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            
            subsets.add(subset);
        }
        
        return subsets;
    }
    
    public static int calculateSumOfXORs(List<List<Integer>> subsets) {
        int sum = 0;
        
        for (List<Integer> subset : subsets) {
            int subsetXOR = 0;
            
            for (int num : subset) {
                subsetXOR ^= num;
            }
            
            sum += subsetXOR;
        }
        
        return sum;
    }
}/*import java.io.*;
import java.util.*;

public class Solution {
 public static long pow(long x,long a)
    {
        long ans=1;
        long m=(long)1e9+7;
        for(int i=0;(1<<i)<=x;i++)
        {
            if((x&(1<<i))!=0)
                ans=(ans*a)%m;
            a=(a*a)%m;
        }
        return (long)ans%m;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {

            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
       long ans=0;
            for(int i=0;i<=31;i++)
            {
                int c=0;
                for(int j=0;j<n;j++)
                {

                if((arr[j]&(1<<i))!=0)
                    c++;
                
                }
                ans=ans+ ((c*(n-c))*(pow(i,2)));
            
            
            }
            System.out.println(ans*2);
        }
    }
} */