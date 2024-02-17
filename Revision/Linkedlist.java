import java.util.Scanner;
import java.util.Arrays;
import java.util.*;;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Method to insert a node at the beginning of the linked list
    public static ListNode insertAtBeginning(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        return newNode;
    }

    // Method to insert a node at the end of the linked list
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

    // Method to delete a node with a specific value
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

    // Method to display the linked list
    public static void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to search for a value in the linked list
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

    // Method to calculate the size of the linked list
    public static int size(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Method to merge two linked lists into one
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

    // Method to sort the elements of the linked list in ascending order
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

    // Method to reverse the linked list
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

    // Method to split a linked list into two separate lists based on a condition
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

    // Method to detect if there is a cycle in the linked list
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // Method to detect if two linked lists intersect and find the intersection node
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    // Method to check if the linked list forms a palindrome
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If the linked list has an odd number of elements, skip the middle element
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

    // Method to create a copy of the linked list
    public static ListNode copy(ListNode head) {
        ListNode newList = null;
        ListNode current = head;

        while (current != null) {
            newList = insertAtEnd(newList, current.val);
            current = current.next;
        }

        return newList;
    }

    // Method to remove duplicate elements from the linked list
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
}

public class Linkedlist {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        list1 = ListNode.insertAtBeginning(list1, 55);
        list1 = ListNode.insertAtEnd(list1, 5);

        ListNode list2 = new ListNode(2);
        list2 = ListNode.insertAtEnd(list2, 4);
        list2 = ListNode.insertAtEnd(list2, 6);

        // Display list1
        System.out.println("List 1:");
        ListNode.display(list1);

        // Display list2
        System.out.println("List 2:");
        ListNode.display(list2);

        // Merge list1 and list2
        ListNode mergedList = ListNode.merge(list1, list2);
        System.out.println("Merged List:");
        ListNode.display(mergedList);

        // Sort the merged list
        System.out.println("Sorted List:");
        ListNode.sort(mergedList);
        ListNode.display(mergedList);

        // Reverse the merged list
        System.out.println("Reversed List:");
        ListNode reversedList = ListNode.reverse(mergedList);
        ListNode.display(reversedList);

        // Split the reversed list
        ListNode[] splitLists = ListNode.split(reversedList, 4);
        System.out.println("List with elements less than 4:");
        ListNode.display(splitLists[0]);
        System.out.println("List with elements greater than or equal to 4:");
        ListNode.display(splitLists[1]);

        // Check for cycle in merged list
        System.out.println("Merged List has cycle? " + ListNode.hasCycle(mergedList));

        // Check if list1 and list2 intersect
        ListNode intersectionNode = ListNode.getIntersectionNode(list1, list2);
        System.out.println("Intersection Node: " + (intersectionNode != null ? intersectionNode.val : "No intersection"));

        // Check if merged list is palindrome
        System.out.println("Is Palindrome? " + ListNode.isPalindrome(mergedList));

        // Create a copy of merged list
        ListNode copiedList = ListNode.copy(mergedList);
        System.out.println("Copied List:");
        ListNode.display(copiedList);

        // Remove duplicates from merged list
        ListNode uniqueList = ListNode.removeDuplicates(mergedList);
        System.out.println("List after removing duplicates:");
        ListNode.display(uniqueList);
    }
}
