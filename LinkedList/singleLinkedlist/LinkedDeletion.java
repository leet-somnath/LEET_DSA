package singleLinkedlist;
import java.util.*;
import java.io.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    ListNode() {

    }
}

public class LinkedDeletion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(10);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head = deletebeg(head);
        display(head);
        deleteEnd(head);
        display(head);
        deleteatPosition(head,1);
        sc.close();
    }

    public static ListNode deletebeg(ListNode head) {
        head = head.next;
        return head;
    }

   public static void deleteAtPosition(ListNode head, int pos) {
        if (head == null || pos < 1) {
            // List is empty or position is invalid
            return;
        }
        
        ListNode temp = head;
        ListNode curr = null;
        
        for (int i = 1; i < pos; i++) {
            if (temp == null) {
                // Position is out of bounds
                return;
            }
            curr = temp;
            temp = temp.next;
        }
        
        if (curr == null) {
            // Deleting the first node
            head = temp.next;
        } else {
            curr.next = temp.next;
        }
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