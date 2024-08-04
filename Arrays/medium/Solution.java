public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] nums) {
         Arrays.sort(nums);
         int[] ans=new int[2];
        int count = 1;
     
        for(int i=0; i< nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                ans[0] = nums[i];
            }
            if(nums[i] <= 0 || nums[i] < count) {
                continue;
            }else {
                if(nums[i] == count) {
                    count++;
                }
                else {
                    ans[1]=count;
             
                }
               
            }
        }
        if(ans[1]==0){
            ans[1]=count;
        }
        return ans;
    }
}