import java.util.*;

public class KFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> result = topKFrequent(nums, k);
        System.out.println("The " + k + " most frequent elements are: " + result);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Count the frequency of each element using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a reverse HashMap to map frequencies to elements
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        for (int key : frequencyMap.keySet()) {
            int freq = frequencyMap.get(key);
            reverseMap.putIfAbsent(freq, new ArrayList<>());
            reverseMap.get(freq).add(key);
        }

        // Traverse the reverse map in descending order of frequencies to find the k most frequent elements
        List<Integer> result = new ArrayList<>();
        for (int freq = nums.length; freq >= 1; freq--) {
            if (reverseMap.containsKey(freq)) {
                for (int num : reverseMap.get(freq)) {
                    result.add(num);
                    if (result.size() == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
