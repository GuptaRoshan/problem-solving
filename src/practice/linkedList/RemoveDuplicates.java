package practice.linkedList;

public class RemoveDuplicates {
    public static Node deleteDuplicates(Node head) {

        // Solved using dummy node.
        Node dummy = new Node(Integer.MIN_VALUE);
        Node curr = dummy;
        Node temp = head;

        while (temp != null) {
            if (curr.data != temp.data) {
                curr.next = temp;
                curr = curr.next;
            }
            temp = temp.next;
        }
        curr.next = null;


        return dummy.next;
    }


    public static void main(String[] args) {
    }
}
