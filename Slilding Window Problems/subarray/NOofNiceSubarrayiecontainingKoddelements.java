class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int oddCount = k;
        int count = 0;
        int temp = 0;

        while (j < nums.length) {
            if (nums[j] % 2 == 1) {
                oddCount--;
                temp = 0;
            }

            while (oddCount == 0) {
                temp++;
                if (nums[i] % 2 == 1) {
                    oddCount++;
                }
                i++;
            }

            count += temp;
            j++;
        }

        return count;
    }
}
