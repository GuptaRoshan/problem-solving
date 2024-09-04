package neetcode150.linkedList;

public class ReorderList_143 {

    public static void reorderList(ListNode head) {
        // Step 1: Find the middle of the list using slow and fast pointers
        if (head == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr; // prev always points to the head of the reversed linked list
            curr = next;
        }
        slow.next = null;  // Disconnect the first half from the second half

        // Step 3: Merge the two lists (first half and reversed second half)
        ListNode head1 = head, head2 = prev;
        while (head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head1 = next1;

            head2.next = head1;
            head2 = next2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        reorderList(head);
        PrintLinkedList.print(head);
    }

}
