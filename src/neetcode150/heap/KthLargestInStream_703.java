package neetcode150.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInStream_703 {

    final Queue<Integer> minHeap = new PriorityQueue<>();
    final int k;

    public KthLargestInStream_703(int k, int[] nums) {
        this.k = k;
        for (int num : nums)
            minHeap.add(num);
    }

    public int add(int val) {
        minHeap.offer(val);

        while (minHeap.size() > k)
            minHeap.poll();

        assert minHeap.peek() != null; // NullPointerException

        return minHeap.peek();
    }


    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        KthLargestInStream_703 kthLargest = new KthLargestInStream_703(k, nums);
        System.out.println(kthLargest.add(3)); // returns 4
        System.out.println(kthLargest.add(5)); // returns 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));  // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
