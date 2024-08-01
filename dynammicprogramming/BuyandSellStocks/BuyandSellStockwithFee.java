/*
 * 

import java.util.*;

class TUF {
    // Function to calculate the maximum profit
    static long maximumProfit(int n, int fee, int[] Arr) {
        // Handle the base case when n is 0
        if (n == 0) {
            return 0;
        }

        long ahead[] = new long[2];
        long cur[] = new long[2];
        
        // Initialize base conditions
        ahead[0] = ahead[1] = 0;
        long profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], Arr[ind] - fee + ahead[0]);
                }
                cur[buy] = profit;
            }

            ahead = (long[]) (cur.clone());
        }
        return cur[0];
    }

    public static void main(String args[]) {
        int prices[] = {1, 3, 2, 8, 4, 9};
        int n = prices.length;
        int fee = 2;

        System.out.println("The maximum profit that can be generated is " + maximumProfit(n, fee, prices));
    }
}



 */
class Solution {
    public int maxProfit(int[] Arr, int fee) {
        int n=Arr.length;
         int dp[][] = new int[n][2];
        
        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        if (n == 0) {
            return 0;
        }
        
        int ans = getAns(Arr, 0, 0, n, fee, dp);
        return ans;
    }
     static int getAns(int[] Arr, int ind, int buy, int n, int fee, int[][] dp) {
        // Base case
        if (ind == n) {
            return 0;
        }

        // If the result is already calculated, return it
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        int profit = 0;

        if (buy == 0) { // We can buy the stock
            profit = Math.max(0 + getAns(Arr, ind + 1, 0, n, fee, dp), -Arr[ind] + getAns(Arr, ind + 1, 1, n, fee, dp));
        }

        if (buy == 1) { // We can sell the stock
            profit = Math.max(0 + getAns(Arr, ind + 1, 1, n, fee, dp), Arr[ind] - fee + getAns(Arr, ind + 1, 0, n, fee, dp));
        }

        // Store the result in dp and return it
        dp[ind][buy] = profit;
        return profit;
    }

}