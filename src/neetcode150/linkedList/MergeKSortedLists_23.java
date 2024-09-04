package neetcode150.linkedList;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            dummy.next = temp;
            dummy = dummy.next;
            temp = temp.next;
            if (temp != null) {
                priorityQueue.add(temp);
            }
        }
        return tail.next;
    }

}
