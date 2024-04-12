class Solution {
    public int maxProfit(int[] prices) {
  int min = Integer.MAX_VALUE;
        int res= 0;
        int max = 0;
        
        for(int i = 0; i < prices.length; i++){
           min=Math.min(min, prices[i]);
            max = prices[i] - min;
           res=Math.max(res,max);
        }
        return res;
    }
}