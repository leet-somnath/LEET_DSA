import java.util.PriorityQueue;

public class QueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements to the queue using offer
        pq.offer(10);
        pq.offer(20);
        pq.offer(15);
//pq.add(33);
        // Removing and printing elements from the queue using poll
        System.out.println(pq.poll());  // Outputs 10
        System.out.println(pq.poll());  // Outputs 15
        System.out.println(pq.poll());  // Outputs 20
        System.out.println(pq.poll());  // Outputs null (since the queue is empty)
    }
}
