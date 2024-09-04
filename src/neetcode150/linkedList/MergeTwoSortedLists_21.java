package neetcode150.linkedList;

public class MergeTwoSortedLists_21 {


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    // This function uses divide and conquer technique to merge two sorted linked lists
    // Along with two pointers, it uses recursion to merge two linked lists
    // Time complexity: O(n + m) where n and m are the lengths of two linked lists
    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        PrintLinkedList.print(mergeTwoLists(head1, head2));

        head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        PrintLinkedList.print(mergeTwoListsRecursive(head1, head2));
    }
}
