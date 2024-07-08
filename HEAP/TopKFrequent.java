public static List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : nums) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue()
    );
    maxHeap.addAll(countMap.entrySet());
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        result.add(maxHeap.poll().getKey());
    }
    return result;
}