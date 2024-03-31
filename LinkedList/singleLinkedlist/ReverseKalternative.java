

public class Solution {
    public ListNode solve(ListNode A, int B) {
        if (A.next == null) {
            return A;
        }
        
        ListNode curr = A;
        ListNode prev = null;
        ListNode forward = null;
        int count = 0;
        
        while (curr != null && count < B) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            count++;
        }
        
        count = 0;
        A.next = forward;
        A = prev;
        
        while (count < B && forward != null) {
            prev = forward;
            forward = forward.next;
            count++;
        }
        
        if (forward != null) {
            prev.next = solve(forward, B);
        }
        
        return A;
    }
}
