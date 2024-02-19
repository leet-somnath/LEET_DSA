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
    