class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);  //Sorting the array
        int res = nums[n-1] - nums[0];  
        // we store the res first for Test cases like
        // k = 3; nums = [1, 2, 3];     <= DO DRY RUN FOR THIS

        for(int i=0; i<n-1; i++){
            int j = i+1;

            int lo = Math.min(nums[0]+k, nums[j]-k);    // nums[0]+k is fixed
            int hi = Math.max(nums[n-1]-k, nums[i]+k);  // nums[n-1]-k is fixed
            
            res = Math.min(res, hi-lo); // Every time we compare the res with the hi-lo
        }
        return res;     // finally return the res
    }
}