<<<<<<< HEAD
import java.util.*;

public class FrogJump {

    public static int frogJump(int n, List<Integer> heights) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(heights.get(i) - heights.get(i - 1));
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = dp[i - 2] + Math.abs(heights.get(i) - heights.get(i - 2));
            }
            dp[i] = Math.min(fs, ss);
        }

        return dp[n - 1]; // or dp[n] if you want the cost to reach the nth index
    }
    public static int frogjumpopt(int n, List<Integer> heights)
    {
        int prev=0,secondprev=0;
        for(int i=1;i<n;i++)
        {
            int fs=prev+Math.abs(heights.get(i)-heights.get(i-1));
            int ss=Integer.MAX_VALUE;
            if(i>1)
            {
                ss=secondprev+Math.abs(heights.get(i)-heights.get(i-2));
            }
            int curr=Math.min(fs,ss);
            secondprev=prev;
            prev=curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        List<Integer> heights = Arrays.asList(10, 30, 40, 20);
        int n = heights.size();
        System.out.println(frogJump(n, heights));  // Output the minimum cost
        System.out.println(frogjumpopt(n, heights));
    }
}
=======
import java.util.*;

public class FrogJump {

    public static int frogJump(int n, List<Integer> heights) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(heights.get(i) - heights.get(i - 1));
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = dp[i - 2] + Math.abs(heights.get(i) - heights.get(i - 2));
            }
            dp[i] = Math.min(fs, ss);
        }

        return dp[n - 1]; // or dp[n] if you want the cost to reach the nth index
    }
    public static int frogjumpopt(int n, List<Integer> heights)
    {
        int prev=0,secondprev=0;
        for(int i=1;i<n;i++)
        {
            int fs=prev+Math.abs(heights.get(i)-heights.get(i-1));
            int ss=Integer.MAX_VALUE;
            if(i>1)
            {
                ss=secondprev+Math.abs(heights.get(i)-heights.get(i-2));
            }
            int curr=Math.min(fs,ss);
            secondprev=prev;
            prev=curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        List<Integer> heights = Arrays.asList(10, 30, 40, 20);
        int n = heights.size();
        System.out.println(frogJump(n, heights));  // Output the minimum cost
        System.out.println(frogjumpopt(n, heights));
    }
}
>>>>>>> 504a43f5310a405e785594a6b52cb9f857ad9822
