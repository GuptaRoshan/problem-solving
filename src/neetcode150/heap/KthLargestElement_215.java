package neetcode150.heap;

import java.util.PriorityQueue;

public class KthLargestElement_215 {

    public static int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

}
