class Solution {
    public int findMaxLength(int[] nums) {
     int maxLen = 0;
        int sum = 0;

       
        Map<Integer, Integer> sumIndices = new HashMap<>();
        sumIndices.put(0, -1); 

        for (int i = 0; i < nums.length; i++) {
           
            sum += (nums[i] == 0) ? -1 : 1;

            // If the running sum is already in the hashmap, update the maximum length
            if (sumIndices.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumIndices.get(sum));
            } else {
                // Otherwise, add the running sum and its index to the hashmap
                sumIndices.put(sum, i);
            }
        }

        return maxLen;
    }
}