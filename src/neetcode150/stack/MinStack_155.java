package neetcode150.stack;

public class MinStack_155 {

    Node head;

    private static class Node{
        int value;
        int min;
        Node next;

        Node(int value, int min, Node next){
            this.value = min;
            this.min = min;
            this.next = next;
        }
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] args){
        MinStack_155 minStack155 = new MinStack_155();
        minStack155.push(4);
        minStack155.push(1);
        minStack155.push(-4);
        System.out.println(minStack155.top());
        minStack155.push(-7);
        System.out.println(minStack155.getMin());
    }
}
