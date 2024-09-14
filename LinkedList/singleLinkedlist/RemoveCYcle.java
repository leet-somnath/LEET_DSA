public class RemoveCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                slow = head;

                // Find the start of the cycle
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Now, `slow` and `fast` point to the start of the cycle.
                return slow;  // Start of cycle
            }
        }

        return null; // No cycle
    }

    public void removeCycle(ListNode head) {
        ListNode startOfCycle = detectCycle(head);
        if (startOfCycle == null) {
            return; // No cycle to remove
        }

        ListNode ptr = startOfCycle;

        // Traverse the cycle until we reach the node just before `startOfCycle`
        while (ptr.next != startOfCycle) {
            ptr = ptr.next;
        }

        // Break the cycle by setting the last node's next to null
        ptr.next = null;
    }
}
