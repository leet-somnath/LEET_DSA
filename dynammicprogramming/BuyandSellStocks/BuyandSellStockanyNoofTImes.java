/*
 * 

import java.util.Arrays;

class StockProfit {
    // Function to calculate the maximum profit
    static long getMaximumProfit(long[] Arr, int n) {
        // Create arrays 'ahead' and 'cur' to store the maximum profit ahead and current profit
        long[] ahead = new long[2];
        long[] cur = new long[2];

        // Base condition: If we have no stocks to buy or sell, profit is 0
        ahead[0] = ahead[1] = 0;

        long profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], Arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Update the 'ahead' array with the current profit values
            System.arraycopy(cur, 0, ahead, 0, 2);
        }
        return cur[0]; // The maximum profit is stored in 'cur[0]'
    }

    public static void main(String args[]) {
        int n = 6;
        long[] Arr = {7, 1, 5, 3, 6, 4};

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
    }
}



 */
import java.util.*;
class BuyandSellStockanyNoofTimes {
    public int maxProfit(int[] prices) {
         Vector<Vector<Long>> dp = new Vector<>(n);
        for (int i = 0; i < n; i++) {
            Vector<Long> row = new Vector<>(2);
            row.addAll(Arrays.asList(-1L, -1L));
            dp.add(row);
        }

        // Base case: If n is 0, return 0 profit
        if (n == 0)
            return 0;

        // Calculate the maximum profit using the recursive function
        long ans = getMaximumProfitUtil(Arr, 0, 0, n, dp);
        return ans;
    }
      static long getMaximumProfitUtil(long[] Arr, int ind, int buy, int n, Vector<Vector<Long>> dp) {
        // Base case
        if (ind == n)
            return 0;

        // If the result is already computed, return it
        if (dp.get(ind).get(buy) != -1)
            return dp.get(ind).get(buy);

        long profit=0;

        if (buy == 0) { // We can buy the stock
            profit = Math.max(0 + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp),
                    -Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp));
        }

        if (buy == 1) { // We can sell the stock
            profit = Math.max(0 + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp),
                    Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp));
        }

        // Store the result in the dp table and return it
        dp.get(ind).set(buy, profit);
        return profit;
    }
}