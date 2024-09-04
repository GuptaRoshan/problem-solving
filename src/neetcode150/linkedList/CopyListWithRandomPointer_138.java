package neetcode150.linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<Node, Node>();

        // Create a deep copy of each node, put into a map
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }


        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

}
