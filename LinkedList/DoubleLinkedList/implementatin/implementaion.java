import java.util.*;

class ListNode {
    int data;
    ListNode prev, next;

    ListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class implementaion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(1);
        insertAtEnd(head, 55);
        display(head);
        
        head = insertAtBeginning(head, 20);
        display(head);
        
        head = insertAtPosition(head, 2, 30);
        display(head);
        
        head = deleteAtPosition(head, 2);
        display(head);
        
        sc.close();
    }

    public static void insertAtEnd(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = null;
    }

    public static ListNode insertAtBeginning(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return head;
    }

    public static ListNode insertAtPosition(ListNode head, int position, int data) {
        ListNode newNode = new ListNode(data);
        ListNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
        return head;
    }

    public static ListNode deleteAtPosition(ListNode head, int position) {
        ListNode temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        return head;
    }
    public static void deleteEnd(ListNode head) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, there is nothing to delete
            return;
        }

        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next.prev=null;
        temp.next = null;
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
