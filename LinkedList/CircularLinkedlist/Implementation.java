import java.util.*;
import java.io.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Implementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(5454);
        display(head);
        head = insertAtBeg(head, 50);
        display(head);
        sc.close();
    }

    public static void display(ListNode head) {
        if (head == null)
            return;
        ListNode temp = head;
        System.out.println(temp.data);
        while (temp.next != head) {
            temp = temp.next;
            System.out.println(temp.data);
        }
    }

    public static ListNode insertAtBeg(ListNode head, int data) {
        ListNode newnode = new ListNode(data);
        if (head == null) {
            newnode.next = newnode; // Point the new node to itself for a circular list
            return newnode;
        }

        ListNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.next = head;
        return newnode;
    }
}
