import java.util.*;
 import java.io.*;
 class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class HasCycle {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
/*
 *  public boolean hasCycle(ListNode head) {
        Set<ListNode> x=new HashSet<>();
        ListNode curr=head;
        while(curr!=null)
        {
            if(x.contains(curr))
            return true;
            else
            x.add(curr);
            curr=curr.next;
        }
        return false;
    }
 */
   
 
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
         while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            return true;
    }
    return false;
}  
sc.close();
    }
}