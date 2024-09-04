package neetcode150.linkedList;

public class PrintLinkedList {

    static String result;

    public static String helper(ListNode head) {
        if (head == null) return result;
        result += head.val + " ";
        return helper(head.next);
    }

    public static void print(ListNode head) {
        result = "";
        System.out.println(helper(head));
    }

}