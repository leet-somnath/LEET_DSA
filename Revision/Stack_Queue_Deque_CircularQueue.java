import java.util.*;

public class Stack_Queue_Deque_CircularQueue {
    public static void main(String[] args) {
        // Stack using LinkedList
        System.out.println("Stack:");
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1); // Pushes element onto the stack
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);
        System.out.println("Top element: " + stack.peek()); // Retrieves but does not remove the top element
        System.out.println("Popped element: " + stack.pop()); // Removes and returns the top element
        System.out.println("Stack after pop: " + stack);

        // Queue using LinkedList
        System.out.println("\nQueue:");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // Adds an element to the end of the queue
        queue.offer(2);
        queue.offer(3);
        System.out.println("Queue: " + queue);
        System.out.println("Front element: " + queue.peek()); // Retrieves but does not remove the front element
        System.out.println("Polled element: " + queue.poll()); // Removes and returns the front element
        System.out.println("Queue after poll: " + queue);

        // Double-ended Queue using LinkedList
        System.out.println("\nDouble-ended Queue:");
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1); // Adds element to the front of the deque
        deque.addLast(2); // Adds element to the end of the deque
        deque.addLast(3);
        System.out.println("Deque: " + deque);
        System.out.println("First element: " + deque.getFirst()); // Retrieves but does not remove the first element
        System.out.println("Last element: " + deque.getLast()); // Retrieves but does not remove the last element
        System.out.println("Removed first element: " + deque.removeFirst()); // Removes and returns the first element
        System.out.println("Deque after removeFirst: " + deque);
        System.out.println("Removed last element: " + deque.removeLast()); // Removes and returns the last element
        System.out.println("Deque after removeLast: " + deque);

        // Circular Queue using ArrayDeque
        System.out.println("\nCircular Queue:");
        Deque<Integer> circularQueue = new ArrayDeque<>(5); // Specifying the fixed size of the circular queue
        circularQueue.add(1);
        circularQueue.add(2);
        circularQueue.add(3);
        circularQueue.add(4);
        System.out.println("Circular Queue: " + circularQueue);
        circularQueue.add(5); // Circular behavior: adding beyond the fixed size wraps around
        System.out.println("Circular Queue after adding: " + circularQueue);
        circularQueue.poll(); // Removes and returns the front element
        System.out.println("Circular Queue after poll: " + circularQueue);
    }
}
