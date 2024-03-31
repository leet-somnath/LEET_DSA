/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        Deque<Integer> x=new ArrayDeque<>();
        while(fast!=null && fast.next!=null)
        {
            x.push(slow.val);
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)
        {
            slow=slow.next;
        }
        while(slow!=null)
        {
            int topval=x.pop();
            if(slow.val!=topval)
             return false;
             slow=slow.next;
        }
        return true;
    }
}