package neetcode150.linkedList;

import trees.TreeNode;

public class LinkedListCycle_141 {

    /**
     * Fast and slow pointer approach to detect cycle in a linked list.
     *
     * @param head head of the linked list
     * @return true if there is a cycle in the linked list, false otherwise
     */
    public static Boolean cycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;

        System.out.println(cycle(head));
    }

}
