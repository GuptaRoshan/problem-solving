package neetcode150.linkedList;

public class ReverseLinkedList_206 {

    public static ListNode reverseListIterative(ListNode head) {
        ListNode previous = null; // It always points to a head of reversed linked list
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    // In the function call head always contains 2nd previous node, if a base case satisfies
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;

        // its last node in the function call or reversed node
        ListNode newHead = reverseListRecursive(head.next);

        // Head is the second last node in the function call
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        PrintLinkedList.print(head);
        PrintLinkedList.print(reverseListRecursive(head));
    }

}
