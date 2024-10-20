package leetcode.linkedList;

public class ReverseLinkedList {
    public static Node reverse(Node head) {
        if (head != null) {
            Node previous = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
        return null;
    }

    public static Node recursiveReverse(Node head) {
        // Base case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive step: reverse the rest of the list
        Node newHead = recursiveReverse(head.next);

        // Make adjustments to reverse the current pair of nodes
        head.next.next = head;
        head.next = null;

        // Return the new head of the reversed list
        return newHead;
    }

    public static void main(String[] args) {

    }
}
