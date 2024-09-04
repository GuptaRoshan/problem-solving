package neetcode150.linkedList;

public class RemoveNthNodeFromEnd_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;

        // Moves pointer to nth times
        for (int i = 0; i < n; i++)
            fast = fast.next;

        // When the nth node is equal to size of the list
        if (fast == null) {
            assert head != null;
            return head.next;
        }

        // Slow will reach to the node before the node to be deleted
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the node
        slow.next = slow.next.next;

        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        PrintLinkedList.print(removeNthFromEnd(head, 2));
    }
}
