package leetcode.linkedList;

public class LinkedList {
    Node head = null;

    public void addInHead(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void addInTail(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void printList(Node root) {
        while (root != null) {
            System.out.println(root.data);
            root = root.next;
        }
    }

}
