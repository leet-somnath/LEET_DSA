<<<<<<< HEAD
import java.util.*;
import java.io.*;

public class MaximumNotAjacentSubsequenceCircularArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
               int n=sc.nextInt();
               int arr[]=new int[n];
                for(int i=0;i<n;i++){ 
              arr[i]=sc.nextInt();
         }
                // get max answer in array except last element from previos dp logic, store in ans1
                // get max answer in array excep first element from previos dp logic, store in ans2
                // return max(ans1,ans2)
                if(n==1)
                {
                    System.out.println(arr[0]);
                    sc.close();
                    return;
                }
                
                int temp[]=new int[n-1];
                int j=0;
                int temp2[]=new int[n-1];
                int k=0;
                for (int i = 0; i < arr.length; i++) {
                    if(i!=n-1)
                        temp[j++]=arr[i];
                    if(i!=0)
                        temp2[k++]=arr[i];
                }
                System.out.println(Math.max(maximumseqIteration(temp),maximumseqIteration(temp2)));
        sc.close();
    }
    public static int maximumseqIteration(int arr[]){
        int dp[]=new int[arr.length];
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int pick=arr[i];
            if(i>1)pick+=dp[i-2];
            int nonpick=dp[i-1];
            dp[i]=Math.max(pick,nonpick);
        }
        return dp[arr.length-1];
    }

=======
import java.util.*;
import java.io.*;

public class MaximumNotAjacentSubsequenceCircularArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
               int n=sc.nextInt();
               int arr[]=new int[n];
                for(int i=0;i<n;i++){ 
              arr[i]=sc.nextInt();
         }
                // get max answer in array except last element from previos dp logic, store in ans1
                // get max answer in array excep first element from previos dp logic, store in ans2
                // return max(ans1,ans2)
                if(n==1)
                {
                    System.out.println(arr[0]);
                    sc.close();
                    return;
                }
                
                int temp[]=new int[n-1];
                int j=0;
                int temp2[]=new int[n-1];
                int k=0;
                for (int i = 0; i < arr.length; i++) {
                    if(i!=n-1)
                        temp[j++]=arr[i];
                    if(i!=0)
                        temp2[k++]=arr[i];
                }
                System.out.println(Math.max(maximumseqIteration(temp),maximumseqIteration(temp2)));
        sc.close();
    }
    public static int maximumseqIteration(int arr[]){
        int dp[]=new int[arr.length];
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int pick=arr[i];
            if(i>1)pick+=dp[i-2];
            int nonpick=dp[i-1];
            dp[i]=Math.max(pick,nonpick);
        }
        return dp[arr.length-1];
    }

>>>>>>> 504a43f5310a405e785594a6b52cb9f857ad9822
}