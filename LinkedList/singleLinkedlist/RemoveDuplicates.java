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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
        return head;
        Set<Integer> x=new HashSet<>();
        ListNode curr=head,prev=null;
        while(curr!=null)
        {
            if(x.contains(curr.val))
            {
                prev.next=curr.next;

            }
            else
            {
                x.add(curr.val);
                prev=curr;
            }
            curr=curr.next;
        }
        return head;
    }
}