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

public class ReverseSingleLinkedListUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode li=new ListNode(2);
        li.next=new ListNode(4);
        li.next.next=new ListNode(3);
        ListNode temp=li;
        int i=0,rev=0;
        int a=reverse(li, temp, i,rev);
        System.out.println(a);
        sc.close();
    }
    
    public static int reverse(ListNode head,ListNode temp,int i,int rev)
    {
        if(temp==null)
        return rev;
        else{
        int digit=temp.data;
        rev+=digit*Math.pow(10,i);
        return reverse(head,temp=temp.next,++i,rev);
        }

    }
}