 import java.util.*;

public class Heap {

    // 1. Find Kth Largest Element in an Array
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
//finding k closest elements in the arrat
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int start = 0;
        int end = arr.length - 1;
        while (end - start >= k) {
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
//2nd approach using heaps
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int integer : arr) {
            if (minHeap.size() < k) {
                minHeap.offer(integer);
          
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.offer(integer);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}
    // 2. Merge K Sorted Lists
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    // 3. Top K Frequent Elements
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

    // 4. Sort an Array
    public static void heapSort(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
        }
        int index = 0;
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    // 5. K Closest Points to Origin
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        while (k-- > 0) {
            result[k] = maxHeap.poll();
        }
        return result;
    }

    // 6. Find Median from Data Stream
    static class MedianFinder {
        private Queue<Integer> maxHeap; 
        private Queue<Integer> minHeap;
    
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }
    
        public void addNum(int num) {
            maxHeap.add(num);
    
            if (maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        }
    
        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (double)(maxHeap.peek() + minHeap.peek()) / 2;
            } else if (maxHeap.size() > minHeap.size()) {
                return (double) maxHeap.peek();
            } else {
                return (double) minHeap.peek();
            }
        }
    }
    

    // 7. Task Scheduler
    public static int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : frequencies) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int i = 0;
            while (i <= n) {
                if (!maxHeap.isEmpty()) {
                    if (maxHeap.peek() > 1) {
                        temp.add(maxHeap.poll() - 1);
                    } else {
                        maxHeap.poll();
                    }
                }
                time++;
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
                i++;
            }
            maxHeap.addAll(temp);
        }
        return time;
    }

    // 8. Find K Pairs with Smallest Sums
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                minHeap.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        List<int[]> result = new ArrayList<>();
        while (k-- > 0 && !minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

    // 9. Furthest Building You Can Reach
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                minHeap.offer(diff);
            }
            if (minHeap.size() > ladders) {
                bricks -= minHeap.poll();
            }
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }

    // 10. Maximize Capital
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= W) {
                maxHeap.offer(minHeap.poll()[1]);
            }
            if (maxHeap.isEmpty()) break;
            W += maxHeap.poll();
        }

        return W;
    }

    // 11. Reorganize String
    public static String reorganizeString(String S) {
        int[] charCounts = new int[26];
        for (char c : S.toCharArray()) {
            charCounts[c - 'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                maxHeap.offer(new int[]{i, charCounts[i]});
            }
        }
        StringBuilder result = new StringBuilder();
        int[] prev = new int[]{-1, 0};
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            if (prev[1] > 0) {
                maxHeap.offer(prev);
            }
            result.append((char) (current[0] + 'a'));
            current[1]--;
            prev = current;
        }
        return result.length() == S.length() ? result.toString() : "";
    }

    // 12. Smallest Range Covering Elements from K Lists
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> nums.get(a[0]).get(a[1])));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int start = 0, end = Integer.MAX_VALUE;
        while (minHeap.size() == nums.size()) {
            int[] curr = minHeap.poll();
            int row = curr[0], col = curr[1];
            if (end - start > max - nums.get(row).get(col)) {
                start = nums.get(row).get(col);
                end = max;
            }
            if (col + 1 < nums.get(row).size()) {
                minHeap.offer(new int[]{row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }
        return new int[]{start, end};
    }

    // 13. Find Kth Smallest Element in a Sorted Matrix
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));
        for (int i = 0; i < Math.min(matrix.length, k); i++) {
            minHeap.offer(new int[]{i, 0});
        }
        int result = 0;
        while (k-- > 0) {
            int[] curr = minHeap.poll();
            result = matrix[curr[0]][curr[1]];
            if (curr[1] < matrix[0].length - 1) {
                minHeap.offer(new int[]{curr[0], curr[1] + 1});
            }
        }
        return result;
    }

    // 14. Minimum Cost to Connect Sticks
    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.offer(stick);
        }
        int totalCost = 0;
        while (minHeap.size() > 1) {
            int cost = minHeap.poll() + minHeap.poll();
            totalCost += cost;
            minHeap.offer(cost);
        }
        return totalCost;
    }

    // 15. Maximum Product of Two Elements in an Array
    public static int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
        }
        int first = maxHeap.poll();
        int second = maxHeap.poll();
        return (first - 1) * (second - 1);
    }

    // 16. Kth Largest Element in a Stream
    static class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (minHeap.size() < k) {
                minHeap.offer(val);
            } else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }

    // 17. Minimize Max Distance to Gas Station
    public static double minmaxGasDist(int[] stations, int K) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int i = 0; i < stations.length - 1; i++) {
            maxHeap.offer(new double[]{stations[i + 1] - stations[i], 1});
        }
        for (int i = 0; i < K; i++) {
            double[] largest = maxHeap.poll();
            maxHeap.offer(new double[]{largest[0] * (largest[1] / (largest[1] + 1)), largest[1] + 1});
        }
        return maxHeap.peek()[0];
    }

    // 18. Sliding Window Maximum
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            if (i >= k - 1) {
                while (maxHeap.peek()[1] < i - k + 1) {
                    maxHeap.poll();
                }
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }
        return result;
    }

    // 19. IPO
    public static int findMaximizedCapitalIPO(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= W) {
                maxHeap.offer(minHeap.poll()[1]);
            }
            if (maxHeap.isEmpty()) break;
            W += maxHeap.poll();
        }

        return W;
    }

    // 20. Sort Characters By Frequency
    public static String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(frequencyMap.entrySet());
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }

    // Utility ListNode class for linked list problems
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        // Example usage for a few problems:
        
        // 1. Find Kth Largest Element
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Kth largest element: " + findKthLargest(nums1, k1)); // Output: 5

        // 2. Merge K Sorted Lists
        ListNode[] lists = {
            new ListNode(1), new ListNode(4), new ListNode(5),
            new ListNode(1), new ListNode(3), new ListNode(4),
            new ListNode(2), new ListNode(6)
        };
        ListNode mergedList = mergeKLists(lists);
        System.out.print("Merged sorted list: ");
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        System.out.println();

        // 3. Top K Frequent Elements
        int[] nums3 = {1, 1, 1, 2, 2, 3};
        int k3 = 2;
        System.out.println("Top K frequent elements: " + topKFrequent(nums3, k3)); // Output: [1, 2]

        // Additional examples can be added for the rest of the methods
    }
}
