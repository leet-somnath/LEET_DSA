class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (n >= length) {
            return head.next;
        }
        int pos = length-n;
        temp = head;
        for (int i = 0; i < pos-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
