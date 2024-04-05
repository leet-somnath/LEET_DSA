import java.io.*;
import java.util.*;

class ListNode {
    int data;
    ListNode next;
    ListNode prev;

    ListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCACHE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Map<Integer, ListNode> map = new HashMap<>();
            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;

            while (n-- > 0) {
                int i = sc.nextInt();
                if (map.containsKey(i)) {
                    ListNode curr = map.get(i);
                    if (curr.next == null)
                        continue;
                    curr.next.prev = curr.prev;
                    curr.prev.next = curr.next;
                    tail.next = curr;
                    curr.prev = tail;
                    tail = tail.next;
tail.next=null;
                } else {
                    ListNode temp = new ListNode(i);
                    tail.next = temp;
                    temp.prev = tail;
                    tail = tail.next;
                    map.put(i, tail);
                    if (map.size() == k + 1) {
                        map.remove(dummy.next.data);
                        dummy.next = dummy.next.next;
                            dummy.next.prev = dummy;
                    }

                }
            }
            display(dummy.next);

        }

    }

    public static void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
