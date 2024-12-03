class FindSumPairs {
    int nums1[];
    int nums2[];
    HashMap<Integer,Integer> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        map = new HashMap<>();
        for(int num: nums2)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
    }
    
    public void add(int index, int val) {
        int oldValue = nums2[index];
        int newValue = oldValue + val;
        nums2[index] = newValue;

        map.put(oldValue, map.get(oldValue)-1);
        if(map.get(oldValue) == 0)
        {
            map.remove(oldValue);
        }
        map.put(newValue, map.getOrDefault(newValue, 0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int num: nums1)
        {
            int tofindValue = tot-num;
            count += map.getOrDefault(tofindValue, 0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */