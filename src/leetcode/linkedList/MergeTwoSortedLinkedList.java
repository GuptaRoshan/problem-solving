package leetcode.linkedList;

public class MergeTwoSortedLinkedList {

    public static Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        while (list1 != null && list2 != null) {
            
            if (list1.data <= list2.data) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }

    public static Node merge_usingRecursion(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.data < l2.data) {
            l1.next = merge_usingRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = merge_usingRecursion(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        list1.addInTail(1);
        list1.addInTail(2);
        list1.addInTail(4);

        LinkedList list2 = new LinkedList();
        list2.addInTail(1);
        list2.addInTail(3);
        list2.addInTail(4);

        mergeTwoLists(list1.head, list2.head);

    }
}
