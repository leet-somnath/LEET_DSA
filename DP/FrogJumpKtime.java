import java.util.*;

public class FrogJumpKtime {
    public static int frogjumprecursion(int n, List<Integer> heights, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n-1, heights, k, dp);

    }

    public static int helper(int index, List<Integer> heights, int k, int dp[]) {
        if (index == 0)
            return 0;
        if (dp[index] != -1)
            return dp[index];

        int minsteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (index - j >= 0) {
                int jumps = helper(index - j, heights, k, dp) + Math.abs(heights.get(index) - heights.get(index - j));
                minsteps = Math.min(minsteps, jumps);
            }
        }
        return dp[index] = minsteps;

    }

    public static int frogJump(int n, List<Integer> heights, int k) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minstep = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jumps = dp[i - j] + Math.abs(heights.get(i) - heights.get(i - j));
                    minstep = Math.min(minstep, jumps);
                }
            }
            dp[i] = minstep;
        }

        return dp[n - 1]; // cost to reach the last index
    }

    public static void main(String[] args) {
        List<Integer> heights = Arrays.asList(30, 10, 60, 10, 60, 50);
        int n = heights.size();
        System.out.println(frogJump(n, heights, 2)); // Output the minimum cost
        System.out.println(frogjumprecursion(n, heights, 2));
    }
}
