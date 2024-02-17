import java.util.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LInkedInsertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode x = new ListNode(3);
        x.next = new ListNode(33);
        x.next.next = new ListNode(55);
        insetionAtEnd(x, sc.nextInt());
        display(x);
        x = insetbegining(x, 00532);
        display(x);
        //
        insertionAtpostion(x, 5568, 3);
        display(x);
        sc.close();
    }

    public static ListNode insetbegining(ListNode head, int data) {
        ListNode newnode = new ListNode(data);
        newnode.next = head;
        return newnode;
    }

    public static void insetionAtEnd(ListNode head, int data) {
        ListNode newnode = new ListNode(data);
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.next = null;
    }

    public static void insertionAtpostion(ListNode head, int data, int pos) {

        ListNode newnode = new ListNode(data);
        ListNode curr = head, temp = head;
        for (int i = 1; i < pos; i++) {
            curr = temp;
            temp = temp.next;

        }
        curr.next = newnode;
        newnode.next = temp;
    }

    public static void display(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;

        }
    }

}