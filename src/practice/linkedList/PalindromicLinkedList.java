package practice.linkedList;

import java.util.Objects;

public class PalindromicLinkedList {
    public static boolean isPalindrome(Node head) {

        // find the middle of linked List
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Move slow pointer one step further if there are odd number of nodes
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse second half of the linked List
        Node previous = null;
        Node current = slow;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        Node temp = head;
        while (previous != null && temp != null) {
            if (!Objects.equals(temp.data, previous.data)) {
                return false;
            }
            previous = previous.next;
            temp = temp.next;
        }

        return true;
    }


    public static void main(String[] args) {
    }

}
