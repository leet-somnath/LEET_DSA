class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode curr = head;
        int size = 1;
        while (curr.next != null) {
            size++;
            curr = curr.next;
        }
        int rc = k % size;
        curr.next = head;
        for (int i = 0; i < size - rc; i++) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}
