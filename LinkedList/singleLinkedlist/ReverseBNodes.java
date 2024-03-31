class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseBNodes {
    public static void main(String[] args) {
        // Create a linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println("Original List:");
        displayList(head);
        int B = 3;
        ListNode result = solve(head, B);
        System.out.println("\nList after reversing every " + B + " nodes:");
        displayList(result);
        }

    public static ListNode solve(ListNode A, int B) {
        if (A == null || B == 1) {
            return A;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode prev = dummy;
        ListNode curr = A;

        while (curr != null) {
            ListNode start = prev.next;
            ListNode nextStart = curr.next;
            int count = 1;
            while (count < B && nextStart != null) {
                    curr.next = nextStart.next;
                nextStart.next = prev.next;
                prev.next = nextStart;
                nextStart = curr.next;
                count++;
            }
            prev = start;
            curr = nextStart;
        }

        return dummy.next;
    }

    public static void displayList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
