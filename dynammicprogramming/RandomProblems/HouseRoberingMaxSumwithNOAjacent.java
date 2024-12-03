class Solution {
    public int rob(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        int max=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            int take=nums[i];
            if(i>1)take+=prev2;
            int notTake=prev;
            int cur1=Math.max(take,notTake);
            prev2=prev;
            prev=cur1;
        }
        return prev;
    }
}