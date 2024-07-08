class Solution {
    public int findkthsmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        return maxHeap.peek();
    }
}