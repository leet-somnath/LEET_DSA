public class Solution {
    public ListNode solve(ListNode A) {
        if (A.next == null || A.next.next == null)
            return A;

        ListNode temp = A;
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = null;

        while (temp != null && temp.next != null) {
            next = temp.next.next;
            curr = temp.next;
            curr.next = prev;
            prev = curr;
            temp.next = next;
            temp = next;
        }

        curr = prev;
        temp = A;

        while (curr != null && temp != null) {
            next = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            temp = curr.next;
            curr = next;
        }

        return A;
    }
}