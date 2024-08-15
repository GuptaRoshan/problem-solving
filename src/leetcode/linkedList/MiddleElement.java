package leetcode.linkedList;

public class MiddleElement {
    public static int middle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (slow != null) ? slow.data : Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
    }
}
