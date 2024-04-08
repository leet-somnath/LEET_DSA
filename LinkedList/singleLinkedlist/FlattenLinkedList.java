class Node {
    int data;
    Node next;
    Node down;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.down = null;
    }
}

public class FlattenLinkedList {
    public Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = flatten(head.next);

        head = merge(head, head.next);

        return head;
    }

    private Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result;
        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }
        return result;
    }
}
