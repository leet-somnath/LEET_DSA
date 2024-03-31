public int findCycleLength(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) { 
            int length = 1;
            slow = slow.next;

            while (slow != fast) {
                length++;
                slow = slow.next;
            }

            return length;
        }
    }

    return 0;
}