class Solution {
    public int candy(int[] nums) {
        int [] left=new int[nums.length];
        left[0]=1;
        int [] right=new int[nums.length];
        right[nums.length-1]=1;
        int ans=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                left[i]=left[i-1]+1;
            }
            
            else{
                left[i]=1;
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                right[i]=right[i+1]+1;
            }
            
            else{
                right[i]=1;
            }
        }
        for(int i=0;i<nums.length;i++){
            ans+=Math.max(left[i],right[i]);
        }
        return ans;
    }
}