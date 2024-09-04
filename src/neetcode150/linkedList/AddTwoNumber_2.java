package neetcode150.linkedList;

public class AddTwoNumber_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0); // Dummy head to simplify the code
        ListNode current = dummyHead; // Pointer to build the result list

        while (carry != 0 || l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Compute the carry for the next digit
            int digit = sum % 10; // Compute the last digit of a sum
            current.next = new ListNode(digit); // Create a new node with the last digit of a sum
            current = current.next; // Move to the next node
        }

        // Return the next node of dummyHead, which is the head of the result list
        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Creating the first linked list: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Creating the second-linked list: 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }


}
