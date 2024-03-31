
class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class MergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        prev.next = null;

        // Recursively sort the two halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Merge the sorted halves
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null)
            current.next = left;
        else
            current.next = right;

        return dummy.next;
    }
}
