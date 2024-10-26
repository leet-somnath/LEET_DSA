import java.util.*;
import java.io.*;

public class MaximumNotAdjacentSubsequenceSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxseqrecursion(arr));
        System.out.println(maximumseqIteration(arr));
        System.out.println(maximumseqoptimal(arr));
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

    public static int maxseqrecursion(int arr[]) {//recursion way
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, dp, arr.length - 1);
    }

    public static int helper(int arr[], int dp[], int index) {
        if (index < 0)
            return 0;
        if (index == 0)
            return arr[0];
        if (dp[index] != -1)
            return dp[index];

        int pick = arr[index] + helper(arr, dp, index - 2);

        int nonpick = helper(arr, dp, index - 1);
        return dp[index] = Math.max(pick, nonpick);
    }

    public static int maximumseqoptimal(int[] nums) {// optimal
        int prev = nums[0];
        int prev2 = 0;
        int max = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1)
                take += prev2;
            int notTake = prev;
            int cur1 = Math.max(take, notTake);
            prev2 = prev;
            prev = cur1;
        }
        return prev;

    }
>>>>>>> 504a43f5310a405e785594a6b52cb9f857ad9822
}