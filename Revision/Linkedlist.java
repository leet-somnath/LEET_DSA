/*
 * insertion,deletion at all points
 * reverse ll
 * merge sort ll
 * merge two sorted list
 * merge two unsorted list
 * split 
 */

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public static ListNode insertAtBeginning(ListNode head, int data) {
    ListNode newNode = new ListNode(data);
    newNode.next = head;
    return newNode;
}

public static ListNode insertAtEnd(ListNode head, int data) {
    ListNode newNode = new ListNode(data);
    if (head == null) {
        return newNode;
    }
    ListNode current = head;
    while (current.next != null) {
        current = current.next;
    }
    current.next = newNode;
    return head;
}

public static ListNode deleteNode(ListNode head, int key) {
    ListNode temp = head;
    ListNode prev = null;

    if (temp != null && temp.val == key) {
        head = temp.next;
        return head;
    }

    while (temp != null && temp.val != key) {
        prev = temp;
        temp = temp.next;
    }

    if (temp == null)
        return head;

    prev.next = temp.next;
    return head;
}

public static void display(ListNode head) {
    ListNode current = head;
    while (current != null) {
        System.out.print(current.val + " ");
        current = current.next;
    }
    System.out.println();
}

public static boolean search(ListNode head, int key) {
    ListNode current = head;
    while (current != null) {
        if (current.val == key) {
            return true;
        }
        current = current.next;
    }
    return false;
}

public static int size(ListNode head) {
    int count = 0;
    ListNode current = head;
    while (current != null) {
        count++;
        current = current.next;
    }
    return count;
}

public static ListNode findMiddle(ListNode head) {
    if (head == null || head.next == null)
        return head;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}

public static ListNode merge(ListNode list1, ListNode list2) {
    ListNode mergedList = null;

    ListNode current = list1;
    while (current != null) {
        mergedList = insertAtEnd(mergedList, current.val);
        current = current.next;
    }

    current = list2;
    while (current != null) {
        mergedList = insertAtEnd(mergedList, current.val);
        current = current.next;
    }

    return mergedList;
}
// sorting the linkedlist using merge sort
/*
 * public class Solution {
 * public ListNode sortList(ListNode head) {
 * if (head == null || head.next == null)
 * return head;
 * 
 * // Find the middle of the list
 * ListNode slow = head;
 * ListNode fast = head;
 * ListNode prev = null;
 * 
 * while (fast != null && fast.next != null) {
 * prev = slow;
 * slow = slow.next;
 * fast = fast.next.next;
 * }
 * 
 * // Split the list into two halves
 * prev.next = null;
 * 
 * // Recursively sort the two halves
 * ListNode left = sortList(head);
 * ListNode right = sortList(slow);
 * 
 * // Merge the sorted halves
 * return merge(left, right);
 * }
 * 
 * private ListNode merge(ListNode left, ListNode right) {
 * ListNode dummy = new ListNode(0);
 * ListNode current = dummy;
 * 
 * while (left != null && right != null) {
 * if (left.val < right.val) {
 * current.next = left;
 * left = left.next;
 * } else {
 * current.next = right;
 * right = right.next;
 * }
 * current = current.next;
 * }
 * 
 * if (left != null)
 * current.next = left;
 * else
 * current.next = right;
 * 
 * return dummy.next;
 * }
 * }
 * 
 */

public static void sort(ListNode head) {
    ListNode current = head;
    ListNode index = null;

    if (head == null) {
        return;
    } else {
        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.val > index.val) {
                    int temp = current.val;
                    current.val = index.val;
                    index.val = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}

public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;

    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
    return head;
}

public static ListNode[] split(ListNode head, int x) {
    ListNode lessThanXList = null;
    ListNode greaterOrEqualXList = null;

    ListNode current = head;
    while (current != null) {
        if (current.val < x) {
            lessThanXList = insertAtEnd(lessThanXList, current.val);
        } else {
            greaterOrEqualXList = insertAtEnd(greaterOrEqualXList, current.val);
        }
        current = current.next;
    }

    ListNode[] result = { lessThanXList, greaterOrEqualXList };
    return result;
}

public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;

    while (a != b) {
        a = (a == null) ? headB : a.next;
        b = (b == null) ? headA : b.next;
    }

    return a;
}

public static boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    Stack<Integer> stack = new Stack<>();

    while (fast != null && fast.next != null) {
        stack.push(slow.val);
        slow = slow.next;
        fast = fast.next.next;
    }

    if (fast != null) {
        slow = slow.next;
    }

    while (slow != null) {
        int top = stack.pop().intValue();

        if (top != slow.val) {
            return false;
        }
        slow = slow.next;
    }
    return true;
}

public static ListNode copy(ListNode head) {
    ListNode newList = null;
    ListNode current = head;

    while (current != null) {
        newList = insertAtEnd(newList, current.val);
        current = current.next;
    }

    return newList;
}

public static ListNode removeDuplicates(ListNode head) {
    HashSet<Integer> set = new HashSet<>();
    ListNode current = head;
    ListNode prev = null;

    while (current != null) {
        if (set.contains(current.val)) {
            prev.next = current.next;
        } else {
            set.add(current.val);
            prev = current;
        }
        current = current.next;
    }

    return head;
}

public boolean hasCycle(ListNode head) {
    if(head==null || head.next==null))
    return false;
    
    ListNode slow=head,fast=head;
     while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if(slow==fast)
        return true;
}
return false;
}

public static boolean detectAndRemoveCycle(ListNode head) {
    if (head == null || head.next == null)
        return false;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast)
            break;
    }

    if (slow == fast) {
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        return true;
    }
    return false;
}

public int findCycleLength(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            int length = 1;
            slow = slow.next;

            while (slow != fast) {
                length++;
                slow = slow.next;
            }

            return length;
        }
    }

    return 0;
}

public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
        return head;
    }
    ListNode curr = head;
    int size = 1;
    while (curr.next != null) {
        size++;
        curr = curr.next;
    }
    int rc = k % size;
    curr.next = head;
    for (int i = 0; i < size - rc; i++) {
        curr = curr.next;
    }
    head = curr.next;
    curr.next = null;
    return head;
}

public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1)
        return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy, curr = head;

    int i = 0;
    while (curr != null) {
        i++;
        if (i % k == 0) {
            prev = reverse(prev, curr.next);
            curr = prev.next;
        } else {
            curr = curr.next;
        }
    }

    return dummy.next;
}

private static ListNode reverse(ListNode prev, ListNode next) {
    ListNode last = prev.next;
    ListNode curr = last.next;

    while (curr != next) {
        last.next = curr.next;
        curr.next = prev.next;
        prev.next = curr;
        curr = last.next;
    }

    return last;
}



public class Linkedlist {
    public static void main(String[] args) {
        // Test cases for various methods
        ListNode list1 = new ListNode(3);
        list1 = insertAtBeginning(list1, 55);
        list1 = insertAtEnd(list1, 5);

        ListNode list2 = new ListNode(2);
        list2 = insertAtEnd(list2, 4);
        list2 = insertAtEnd(list2, 6);

        System.out.println("List 1:");
        display(list1);

        System.out.println("List 2:");
        display(list2);

        ListNode mergedList = merge(list1, list2);
        System.out.println("Merged List:");
        display(mergedList);

        System.out.println("Sorted List:");
        sort(mergedList);
        display(mergedList);

        System.out.println("Reversed List:");
        ListNode reversedList = reverse(mergedList);
        display(reversedList);

        ListNode[] splitLists = split(reversedList, 4);
        System.out.println("List with elements less than 4:");
        display(splitLists[0]);
        System.out.println("List with elements greater than or equal to 4:");
        display(splitLists[1]);

        System.out.println("Merged List has cycle? " + hasCycle(mergedList));

        ListNode intersectionNode = getIntersectionNode(list1, list2);
        System.out
                .println("Intersection Node: " + (intersectionNode != null ? intersectionNode.val : "No intersection"));

        System.out.println("Is Palindrome? " + isPalindrome(mergedList));

        ListNode copiedList = copy(mergedList);
        System.out.println("Copied List:");
        display(copiedList);

        ListNode uniqueList = removeDuplicates(mergedList);
        System.out.println("List after removing duplicates:");
        display(uniqueList);

        // Additional Problems
        System.out.println("Detecting and Removing Cycle:");
        detectAndRemoveCycle(mergedList);
        display(mergedList);

        System.out.println("Middle Node:");
        ListNode middleNode = findMiddle(mergedList);
        System.out.println(middleNode != null ? middleNode.val : "No middle node");

        System.out.println("Reversing Every K Nodes:");
        ListNode reversedKNodes = reverseKGroup(mergedList, 3);
        display(reversedKNodes);

        ListNode intersection = detectIntersection(list1, list2);
        System.out.println("Intersection Node: " + (intersection != null ? intersection.val : "No intersection"));
    }
}
