class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k - 1);
    }

    public int subarraysWithAtMostKDistinct(int[] nums, int k) {
        if (k == 0) return 0;
        
        int i = 0;
        int j = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() > k && i <= j) {
                if (map.get(nums[i]) == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
                i++;
            }

            res += j - i + 1;
            j++;
        }

        return res;
    }
}