package neetcode150.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream_295 {

    private final PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    private final PriorityQueue<Integer> large = new PriorityQueue<>(); // min heap
    private boolean even = true;

    public double findMedian() {
        assert small.peek() != null;
        assert large.peek() != null;

        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }

    public void addNum(int num) {
        if (even) { // Moves a smaller element from min heap to max heap
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num); // Moves a larger element from max heap to min heap
            large.offer(small.poll());
        }
        even = !even;
    }

    public static void main(String[] args) throws InterruptedException {
        MedianFromDataStream_295 medianFinder = new MedianFromDataStream_295();
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(67);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }

}
