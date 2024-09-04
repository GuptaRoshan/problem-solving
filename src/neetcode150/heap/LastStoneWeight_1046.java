package neetcode150.heap;

import java.util.PriorityQueue;

public class LastStoneWeight_1046 {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            maxHeap.add(maxHeap.poll() - maxHeap.poll());
        }

        return maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }
}
