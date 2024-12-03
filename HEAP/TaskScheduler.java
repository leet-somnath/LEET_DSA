import java.util.*;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) freq[task - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) if (f > 0) pq.add(f);

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll() - 1);
                }
            }
            for (int t : temp) {
                if (t > 0) pq.add(t);
            }
            time += pq.isEmpty() ? temp.size() : n + 1;
        }
        
        return time;
    }
}
