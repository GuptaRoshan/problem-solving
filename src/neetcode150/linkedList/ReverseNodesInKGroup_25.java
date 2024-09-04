package neetcode150.linkedList;

public class ReverseNodesInKGroup_25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy; // End of the previous group
        ListNode current = head; // Current node in the group
        ListNode nextNode = null; // To temporarily store the next node in the group

        // Compute the length of the list
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }

        // Number of complete k-sized groups
        int numGroups = length / k;

        // Process each k-sized group
        while (numGroups > 0) {
            ListNode groupStart = prevGroupEnd.next; // Start of the current group
            ListNode prev = null; // Previous node in the group
            current = groupStart; // Current node in the group

            // Reverse the nodes in the current group
            for (int i = 0; i < k; i++) {
                nextNode = current.next; // Store the next node
                current.next = prev; // Reverse the current node's link
                prev = current; // Move prev forward
                current = nextNode; // Move to the next node
            }

            // Connect the reversed group with the rest of the list
            prevGroupEnd.next.next = current; // Connect the end of the reversed group with the remaining list
            prevGroupEnd.next = prev; // Connect the previous group's end with the start of the reversed group

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;

            numGroups--; // Process the next group
        }

        return dummy.next; // Return the new head of the list
    }

    public static void main(String[] args) {
        // Manually create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        System.out.println(reverseKGroup(head, k));

    }

}
