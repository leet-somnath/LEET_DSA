class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int flip = k;
        int max = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                flip--;
            }
            while (flip < 0) {
                if (nums[i] == 0) {
                    flip++;
                }
                i++;
            }
            max = Math.max(max, j - i + 1); 
        }
        return max;
    }
}
