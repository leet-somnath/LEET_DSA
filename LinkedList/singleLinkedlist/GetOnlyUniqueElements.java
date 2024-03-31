import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        ListNode curr = head;
        
        while (curr != null) {
            int value = curr.val;
            frequencyMap.put(value, frequencyMap.containsKey(value) ? frequencyMap.get(value) + 1 : 1);
            curr = curr.next;
        }
        
        ListNode newHead = null;
        ListNode tail = null;
        
        curr = head;
        while (curr != null) {
            int value = curr.val;
            if (frequencyMap.get(value) == 1) {
                ListNode newNode = new ListNode(value);
                if (newHead == null) {
                    newHead = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
            curr = curr.next;
        }
        
        return newHead;
    }
}
