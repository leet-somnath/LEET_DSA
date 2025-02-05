class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a priority queue (Min-Heap) to store the top k elements
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (frequencyMap.get(a).equals(frequencyMap.get(b))) {
                return b.compareTo(a); // If same frequency, sort lexicographically (reverse order)
            }
            return frequencyMap.get(a) - frequencyMap.get(b); // Sort by frequency (min heap)
        });

        // Step 3: Maintain a heap of size k
        for (String word : frequencyMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // Remove least frequent or lexicographically larger word
            }
        }

        // Step 4: Retrieve elements from the heap in reverse order
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result); // Since we used a min-heap, reversing gives the correct order

        return result;
    }
}